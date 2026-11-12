package com.xworkz.Inventar.Service.impl;

import com.xworkz.Inventar.Service.EmailService;
import com.xworkz.Inventar.Service.RegisterService;
import com.xworkz.Inventar.dto.LoginDto;
import com.xworkz.Inventar.dto.RegisterDTO;
import com.xworkz.Inventar.entity.RegisterEntity;
import com.xworkz.Inventar.refo.RegisterRepository;
import com.xworkz.Inventar.util.InventarUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
@Slf4j
public class RegisterServiceImpl implements RegisterService {

    private static final String UPLOAD_DIR = "src/main/webapp/uploads";
    private static final long MAX_FILE_SIZE = 2 * 1024 * 1024; // 2 MB

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder;
    @Autowired
    private EmailService emailService;


    @Override
    public String registerService(RegisterDTO dto) {
        log.info("Running save() in RegisterServiceImpl");
        log.info("RegisterDTO: " + dto);

        log.info("Running save() in RegisterServiceImpl");
        log.info("RegisterDTO: " + dto);

        if (dto == null) {
            return "Invalid registration details";
        }

        log.info("Saving RegisterDTO");

        // Check email
        if (registerRepository.emailExists(dto.getEmail())) {
            log.info("Email Id Already Exist");
            return "Email Id Already Exist";
        }

        // Check phone number
        if (registerRepository.phoneNumberExists(dto.getMobileNumber())) {
            log.info("Phone Number Already Exist");
            return "Phone Number Already Exist";
        }

        RegisterEntity registerEntity = new RegisterEntity();

        String encodedPassword = bcryptPasswordEncoder.encode(dto.getPassword());

        dto.setPassword(encodedPassword);
        BeanUtils.copyProperties(dto, registerEntity);

        String imageName = saveProfileImage(dto.getFile());
        if (imageName != null) {
            registerEntity.setProfileImage(imageName);
        }

       registerRepository.rejestarRefo(registerEntity);
        log.info("Registration successful");

        return "Registration Successful";
    }


    @Override
    public String findEmail(String email) {
        log.info("Service received: [" + email + "]");

        Boolean exists = registerRepository.emailExists(email);

        return exists ? "Email Id Already Exist" : "Email Id not Exist";
    }

    @Override
    public String findPhoneNumber(String phoneNumber) {

        log.info("Invoking findPhoneNumber:Service " + phoneNumber);
        String status = null;

        if (phoneNumber != null) {

            Boolean isCheck = registerRepository.phoneNumberExists(phoneNumber);
            status = (isCheck) ? "Phone Number Already Exist" : "Phone Number Not Exist";
        }

        return status;
    }

    @Override
    public RegisterDTO loginService(LoginDto dto) {
        log.info("Running loginService() in RegisterServiceImpl");
        log.info("Running checkUserByLogin()");

        if (dto == null) {
            return null;
        }

        RegisterEntity entity = registerRepository.findEntityByEmail(dto.getEmail());

        if (entity == null) {
            log.info("Email not found in database");
            return null;
        }

        // Use this if the stored password is BCrypt encoded
        boolean matched = bcryptPasswordEncoder.matches(
                dto.getPassword(),
                entity.getPassword()
        );

        if (matched) {
            RegisterDTO dto1 = new RegisterDTO();
            BeanUtils.copyProperties(entity, dto1);
            return dto1;
        }

        System.out.println("Password does not match");
        return null;
    }



    @Override
    public boolean updateProfile(RegisterDTO registerDTO) {

        if (registerDTO == null || registerDTO.getEmail() == null) {
            return false;
        }

        RegisterEntity entity = registerRepository.findEntityByEmail(registerDTO.getEmail());

        if (entity == null) {
            return false;
        }

        entity.setName(registerDTO.getName());
        entity.setMobileNumber(registerDTO.getMobileNumber());
        entity.setAddress(registerDTO.getAddress());
        entity.setGender(registerDTO.getGender());

        String imageName = saveProfileImage(registerDTO.getFile());
        if (imageName != null) {
            entity.setProfileImage(imageName);
        }

        registerRepository.update(entity);

        return true;
    }

    @Override
    public boolean updateProfileImage(String email, MultipartFile file) {
        if (email == null || file == null || file.isEmpty()) {
            return false;
        }

        RegisterEntity entity = registerRepository.findEntityByEmail(email);

        if (entity == null) {
            log.warn("User not found for image update: {}", email);
            return false;
        }

        String imageName = saveProfileImage(file);

        if (imageName == null) {
            return false;
        }

        entity.setProfileImage(imageName);
        registerRepository.update(entity);

        log.info("Profile image updated for: {}", email);
        return true;
    }

    private String saveProfileImage(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return null;
        }

        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            log.warn("Invalid file type for profile image: {}", contentType);
            return null;
        }

        if (file.getSize() > MAX_FILE_SIZE) {
            log.warn("Profile image too large: {} bytes", file.getSize());
            return null;
        }

        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String originalName = file.getOriginalFilename();
            String extension = "";
            if (originalName != null && originalName.contains(".")) {
                extension = originalName.substring(originalName.lastIndexOf("."));
            }

            String fileName = UUID.randomUUID().toString() + extension;
            Path filePath = uploadPath.resolve(fileName);

            Files.copy(file.getInputStream(), filePath);

            log.info("Profile image saved: {}", filePath);
            return fileName;

        } catch (IOException e) {
            log.error("Failed to save profile image", e);
            return null;
        }
    }

    @Override
    public boolean sendEmail(String email) {
        log.info("Running sendEmail() in RegisterServiceImpl");
        boolean isCheck=registerRepository.emailExists(email);

        if(isCheck){
            String otp = String.valueOf((int) (Math.random() * 900000) + 100000);

            log.info("OTP: " + otp);
          boolean isSend=  emailService.sendEmail(email, otp);

            if(isSend){
                log.info("OTP sent successfully");
                boolean isSaved=registerRepository.saveOtp(email,otp);
                log.info("OTP saved successfully");
                if(isSaved){
                    return true;                 }
            }else{
                return false;
            }

            log.info("Email sent successfully");
        }
        return false;
    }

    @Override
    public RegisterDTO verifyOtp(String email, String otp) {
        log.info("Running verifyOtp() in RegisterServiceImpl");
        RegisterDTO registerDTO=null;
        if(email!=null && otp!=null){
            RegisterEntity entity = registerRepository.findEntityByEmail(email);
            if(entity!=null && entity.getOtp().equals(otp)){
                registerDTO = new RegisterDTO();
                BeanUtils.copyProperties(entity, registerDTO);
            }
        }
        return registerDTO;
    }

    @Override
    public boolean fogetPassword(String email) {
        RegisterEntity entity = registerRepository.findEntityByEmail(email);

        if (entity == null) {
            log.warn("Email not found: {}", email);
            return false;
        }

        String token = InventarUtil.generateResetToken();

        entity.setResetToken(token);
        entity.setResetTokenExpiry(LocalDateTime.now().plusMinutes(15));
       registerRepository.update(entity);

        String resetUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/register/resetPassword")
                .queryParam("token", token)
                .toUriString();

        String body = "Click the link below to reset your password:\n" + resetUrl
                + "\nThis link expires in 15 minutes.";

        return emailService.sendEmail(
                email,
                "Password Reset",
                body
        );
    }

    @Override
    public boolean resetPassword(String token, String newPassword) {

        RegisterEntity entity = registerRepository.findEntityByResetToken(token);

        if (entity == null) {
            return false;
        }

        // Check token expiry
        if (entity.getResetTokenExpiry() == null
                || entity.getResetTokenExpiry().isBefore(LocalDateTime.now())) {
            return false;
        }

        // Update password and unblock account
        entity.setPassword(bcryptPasswordEncoder.encode(newPassword));
        entity.setAttempts(0);
        entity.setBlocked(false);

        // Invalidate token so it cannot be reused
        entity.setResetToken(null);
        entity.setResetTokenExpiry(null);

       registerRepository.update(entity);

        return true;
    }


    @Override
    public RegisterDTO findUserByEmail(String email) {

        RegisterEntity entity = registerRepository.findEntityByEmail(email);

        if (entity == null) {
            return null;
        }

        RegisterDTO dto = new RegisterDTO();
        BeanUtils.copyProperties(entity, dto);
        dto.setPassword(null);
        return dto;
    }
}

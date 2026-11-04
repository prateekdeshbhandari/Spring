package com.xworkz.Inventar.Service.impl;

import com.xworkz.Inventar.Service.EmailService;
import com.xworkz.Inventar.Service.RegisterService;
import com.xworkz.Inventar.dto.LoginDto;
import com.xworkz.Inventar.dto.RegisterDTO;
import com.xworkz.Inventar.entity.RegisterEntity;
import com.xworkz.Inventar.refo.RegisterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RegisterServiceImpl implements RegisterService {
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

        registerRepository.update(entity);

        return true;
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

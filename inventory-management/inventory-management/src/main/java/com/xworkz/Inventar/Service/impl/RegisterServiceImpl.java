package com.xworkz.Inventar.Service.impl;

import com.xworkz.Inventar.Service.EmailService;
import com.xworkz.Inventar.Service.RegisterService;
import com.xworkz.Inventar.dto.LoginDto;
import com.xworkz.Inventar.dto.RegisterDTO;
import com.xworkz.Inventar.entity.RegisterEntity;
import com.xworkz.Inventar.refo.RegisterRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder;
    @Autowired
    private EmailService emailService;


    @Override
    public String registerService(RegisterDTO dto) {
        System.out.println("Running save() in RegisterServiceImpl");
        System.out.println("RegisterDTO: " + dto);

        System.out.println("Running save() in RegisterServiceImpl");
        System.out.println("RegisterDTO: " + dto);

        if (dto == null) {
            return "Invalid registration details";
        }

        System.out.println("Saving RegisterDTO");

        // Check email
        if (registerRepository.emailExists(dto.getEmail())) {
            System.out.println("Email Id Already Exist");
            return "Email Id Already Exist";
        }

        // Check phone number
        if (registerRepository.phoneNumberExists(dto.getMobileNumber())) {
            System.out.println("Phone Number Already Exist");
            return "Phone Number Already Exist";
        }

        RegisterEntity registerEntity = new RegisterEntity();

        String encodedPassword = bcryptPasswordEncoder.encode(dto.getPassword());

        dto.setPassword(encodedPassword);
        BeanUtils.copyProperties(dto, registerEntity);

       registerRepository.rejestarRefo(registerEntity);
        System.out.println("Registration successful");

        return "Registration Successful";
    }


    @Override
    public String findEmail(String email) {
        System.out.println("Service received: [" + email + "]");

        Boolean exists = registerRepository.emailExists(email);

        return exists ? "Email Id Already Exist" : "Email Id not Exist";
    }

    @Override
    public String findPhoneNumber(String phoneNumber) {

        System.out.println("Invoking findPhoneNumber:Service " + phoneNumber);
        String status = null;

        if (phoneNumber != null) {

            Boolean isCheck = registerRepository.phoneNumberExists(phoneNumber);
            status = (isCheck) ? "Phone Number Already Exist" : "Phone Number Not Exist";
        }

        return status;
    }

    @Override
    public RegisterDTO loginService(LoginDto dto) {
        System.out.println("Running loginService() in RegisterServiceImpl");
        System.out.println("Running checkUserByLogin()");

        if (dto == null) {
            return null;
        }

        RegisterEntity entity = registerRepository.findEntityByEmail(dto.getEmail());

        if (entity == null) {
            System.out.println("Email not found in database");
            return null;
        }

        // Use this if the stored password is BCrypt encoded
        boolean matched = bcryptPasswordEncoder.matches(
                dto.getPassword(),
                entity.getPassword()
        );

        if (matched) {
            RegisterDTO dto1 = new RegisterDTO();
            BeanUtils.copyProperties(entity, dto);
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
    public void sendEmail(String email) {
        System.out.println("Running sendEmail() in RegisterServiceImpl");
        if(email!=null){
            String otp = String.valueOf((int) (Math.random() * 900000) + 100000);

            System.out.println("OTP: " + otp);
            emailService.sendEmail(email, otp);
            System.out.println("Email sent successfully");

        }
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

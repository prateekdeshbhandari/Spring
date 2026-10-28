package com.xworkz.Inventar.Service.impl;

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

    @Override
    public boolean registerService(RegisterDTO dto) {
        System.out.println("Running save() in RegisterServiceImpl");
        System.out.println("RegisterDTO: " + dto);
        if(dto!=null){
            System.out.println("RegisterDTO is not null, saving...");
            try {
                RegisterEntity registerEntity=new RegisterEntity();
                BeanUtils.copyProperties(dto, registerEntity);
                String encodedPassword = bcryptPasswordEncoder.encode(dto.getPassword());
                registerEntity.setPassword(encodedPassword);
                System.out.println("RegisterEntity: " + registerEntity);
                this.registerRepository.rejestarRefo(registerEntity);
                System.out.println("Entity persisted successfully");
                return true;
            } catch (Exception e) {
                System.out.println("Error saving registration: " + e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public RegisterDTO loginService(LoginDto dto) {
        System.out.println("Running loginService() in RegisterServiceImpl");
        System.out.println("Running checkUserByLogin()");

        if (dto == null) {
            return null;
        }

        RegisterEntity entity = registerRepository.findByEmail(dto.getEmail());

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
}

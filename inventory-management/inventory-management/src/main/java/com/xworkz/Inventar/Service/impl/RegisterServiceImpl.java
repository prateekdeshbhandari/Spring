package com.xworkz.Inventar.Service.impl;

import com.xworkz.Inventar.Service.RegisterService;
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
    RegisterEntity registerEntity=new RegisterEntity();
    BeanUtils.copyProperties(dto, registerEntity);
    String encodedPassword = bcryptPasswordEncoder.encode(dto.getPassword());
    registerEntity.setPassword(encodedPassword);
    System.out.println("RegisterEntity: " + registerEntity);
    this.registerRepository.rejestarRefo(registerEntity);
    return true;
}
        return false;
    }
}

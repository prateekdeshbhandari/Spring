package com.xworkz.PS5.Component;

import com.xworkz.PS5.dto.Ps5ProDTO;
import com.xworkz.PS5.service.PS5ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class PS5Components {
    public PS5Components() {

        System.out.println("Created PS5Components with service: ");
    }
    @Autowired
    private PS5ProService ps5ProService;


@RequestMapping("/PS5")
public  String ps5Pro(@Valid Ps5ProDTO dto, BindingResult bindingResult){
    System.out.println("ps5Pro method called with DTO: " + dto);
    if(bindingResult.hasErrors()){
        System.out.println("Validation failed: " + bindingResult.getAllErrors());
        ps5ProService.validateAndSave(dto);

    }else{
        ps5ProService.validateAndSave(dto);
    }

    return "Ps5Pro.jsp";
}
}

package com.xworkz.component;

import com.xworkz.dto.MobileDTO;
import com.xworkz.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
@Controller
@RequestMapping("/")
public class MobileComponent {
    @Autowired
    private MobileService mobileService;
    @RequestMapping("/mobile")
    public String mobile(Model model, @Valid MobileDTO dto , BindingResult bindingResult){
        System.out.println("running the mobile method");
        System.out.println("Received DTO: " + dto);
        if(!bindingResult.hasErrors()) {
            System.out.println("valid data: ");
            mobileService.validetionAndSave(dto);
            model.addAttribute("sucssess", "Mobile registered successfully!");
        }else {
            System.out.println("invalid data: ");
            model.addAttribute("error", "Validation failed. Please check the form.");
            List<ObjectError> error = bindingResult.getAllErrors();
            model.addAttribute("errors", error);
            model.addAttribute("mobile dto",dto);
        }
        return "/Mobile.jsp";
    }
}

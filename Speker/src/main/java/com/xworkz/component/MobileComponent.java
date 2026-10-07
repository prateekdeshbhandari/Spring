package com.xworkz.component;

import com.xworkz.dto.MobileDTO;
import com.xworkz.service.MobileService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/mobile")
public class MobileComponent {




    @Autowired
    private MobileService mobileService;
    List<String>mobileBrand;
    public MobileComponent(){
        System.out.println("Created MobileComponent using no-arg constructor...");
    }

@PostConstruct
    public  void onInit(){
     mobileBrand= Stream.of("Samsung", "Apple", "OnePlus", "Vivo", "Oppo").collect(Collectors.toList());
    }
   @PostMapping
    public String mobile(Model model, @Valid MobileDTO dto , BindingResult bindingResult){
        System.out.println("running the mobile method");
        System.out.println("Received DTO: " + dto);
        if(!bindingResult.hasErrors()) {
            System.out.println("valid data: ");
            mobileService.validetionAndSave(dto);
            model.addAttribute("sucssess", "Mobile registered successfully!");
            model.addAttribute("mobileDTO",new MobileDTO());
            model.addAttribute("mobileBrand",mobileBrand);


        }else {
            System.out.println("invalid data: ");
            model.addAttribute("error", "Validation failed. Please check the form.");
            List<ObjectError> error = bindingResult.getAllErrors();
            model.addAttribute("errors", error);
            model.addAttribute("mobile dto",dto);
        }
        return "/Mobile.jsp";
    }
    @GetMapping
    public String getMobile(Model model){
        System.out.println("running getMobile(), loading mobil.jsp");
        model.addAttribute("mobileBrand", mobileBrand);
        return "/Mobile.jsp";
    }
}

package com.xworkz.Inventar.controllar;

import com.xworkz.Inventar.Service.RegisterService;
import com.xworkz.Inventar.dto.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    public RegisterController(){
        System.out.println("Created RegisterController...");
    }
    @GetMapping
    public String onLoadRegister(Model model){
        System.out.println("Running onLoadRegister in RegisterController...");
        model.addAttribute("registerDTO", new RegisterDTO());
        return "Register";
    }

  @PostMapping
    public String onRegister(@Valid @ModelAttribute("registerDTO") RegisterDTO registerDTO, BindingResult bindingResult, Model model){
        System.out.println("Running onRegister in RegisterController...");

        if(bindingResult.hasErrors()){
            System.out.println("Validation failed:");
            List<ObjectError>error=bindingResult.getAllErrors();
           model.addAttribute("error", error);

        }else {
            this.registerService.registerService(registerDTO);
            model.addAttribute("successMessage", "Register details saved successfully");
            model.addAttribute("RegisterDto", new RegisterDTO());

        }
      return "Register";

    }
}

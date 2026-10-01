package com.xworkz.component;

import com.xworkz.dto.TelephoneOperatorDTO;
import com.xworkz.service.TelephoneOperatorService;
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
public class TelephoneComponent {

    @Autowired
    private TelephoneOperatorService telephoneOperatorService;
    @RequestMapping("/telephone")
    public String telephone(Model model, @Valid TelephoneOperatorDTO dto , BindingResult bindingResult){
        System.out.println("running the telephone method");
        System.out.println("Received DTO: " + dto);
        if(!bindingResult.hasErrors()) {
            System.out.println("valid data: ");
            telephoneOperatorService.validetionAndSave(dto);
            model.addAttribute("sucssess", "Telephone registered successfully!");
        }
        else {
            System.out.println("invalid data: ");
            model.addAttribute("error", "Validation failed. Please check the form.");
            List<ObjectError> error = bindingResult.getAllErrors();
            model.addAttribute("errors", error);
            model.addAttribute("telephonedto",dto);
        }
        return "/Telephone.jsp";
    }
}

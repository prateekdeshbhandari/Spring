package com.xworkz.component;

import com.xworkz.dto.ContactDTO;
import com.xworkz.service.ContactService;
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
public class ContactComponent {
    @Autowired
    private ContactService contactService;
    @RequestMapping("/contact")
    public String contact(Model model, @Valid ContactDTO dto , BindingResult bindingResult){
        System.out.println("running the contact method");
        System.out.println("Received DTO: " + dto);
        if(!bindingResult.hasErrors()) {
            System.out.println("vaid  dtos data");
            contactService.validetionAndSavd(dto);
            model.addAttribute("sucssess", "Contact registered successfully!");

        }else {
            System.out.println("validet data error plize fix it: ");
            model.addAttribute("error", "Validation failed. Please check the form.");
            List<ObjectError> error = bindingResult.getAllErrors();
            model.addAttribute("errors", error);
            model.addAttribute("contactdto",dto);
        }
        return "/Contect.jsp";
    }
}

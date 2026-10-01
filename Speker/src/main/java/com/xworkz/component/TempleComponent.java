package com.xworkz.component;

import com.xworkz.dto.TempleDTO;
import com.xworkz.service.TempleService;
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
public class TempleComponent {

    @Autowired
    private TempleService templeService;
    @RequestMapping("/temple")
    public String temple(Model model, @Valid TempleDTO dto , BindingResult bindingResult){
        System.out.println("running the temple method");
        System.out.println("Received DTO: " + dto);
        if(!bindingResult.hasErrors()) {
            System.out.println("valid dtat: ");
            templeService.validetionAndSave(dto);
            model.addAttribute("sucssess", "Temple registered successfully!");
        }else {
            System.out.println("invalid data: ");
            model.addAttribute("error", "Validation failed. Please check the form.");
            List<ObjectError> error = bindingResult.getAllErrors();
            model.addAttribute("errors", error);
            model.addAttribute("templ dto",dto);
        }
        return "/Temple.jsp";
    }

}

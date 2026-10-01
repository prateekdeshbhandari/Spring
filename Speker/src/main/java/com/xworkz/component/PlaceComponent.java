package com.xworkz.component;

import com.xworkz.dto.PlaceDTO;
import com.xworkz.service.PlaceService;
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
public class PlaceComponent {
    @Autowired
    private PlaceService placeService;

    @RequestMapping("/place")
    public String place(Model model, @Valid PlaceDTO dto , BindingResult bindingResult){
        System.out.println("running the place method");
        System.out.println("Received DTO: " + dto);
        if(bindingResult.hasErrors()) {


            System.out.println("vaklide  error plize pix: ");
            placeService.vaalidetionAndSave(dto);
            model.addAttribute("error", "Validation failed. Please check the form.");
            List<ObjectError> error = bindingResult.getAllErrors();
            model.addAttribute("errors", error);

            model.addAttribute("placedto",dto);
            System.out.println("PlaceDTO: " + bindingResult.getAllErrors());
        }else {
            System.out.println("validet dtos data");

            model.addAttribute("sucssess", "Place registered successfully!");

        }
        return "/Place.jsp";
    }
}

package com.xworkz.component;

import com.xworkz.dto.CameraDTO;
import com.xworkz.service.CameraService;
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
public class CameraComponent {
    @Autowired
    private CameraService cameraService;
    @RequestMapping("/camera")
        public String camera(Model model, @Valid CameraDTO dto , BindingResult bindingResult){
        System.out.println("running the camera method");
        System.out.println("Received DTO: "+dto);
        if(!bindingResult.hasErrors()){
            System.out.println("valid data: ");
            cameraService.validetionAndSave(dto);

            model.addAttribute("sucssess","Camera registered successfully!");
        }
        else {
            System.out.println("invalid data: ");
            model.addAttribute("error", "Validation failed. Please check the form.");
            List<ObjectError> error = bindingResult.getAllErrors();
            model.addAttribute("errors", error);
            model.addAttribute("cameradto", dto);
        }
        return "/Camera.jsp";
    }
}

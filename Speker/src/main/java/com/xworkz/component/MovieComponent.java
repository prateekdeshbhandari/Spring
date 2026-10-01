package com.xworkz.component;

import com.xworkz.dto.MovieDTO;
import com.xworkz.service.MovieService;
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
public class MovieComponent {

    @Autowired
    private MovieService movieService;
    @RequestMapping("/movie")
    public String movie(Model model, @Valid MovieDTO dto , BindingResult bindingResult){
        System.out.println("running the movie method");
        System.out.println("Received DTO: "+dto);
        if (!bindingResult.hasErrors()){
            System.out.println("dtat valide: ");
            movieService.validetionAndSave(dto);
            model.addAttribute("sucssess","Movie registered successfully!");
        }else {
            System.out.println("dtat invalide: ");
            model.addAttribute("error", "Validation failed. Please check the form.");
            List<ObjectError> error = bindingResult.getAllErrors();
            model.addAttribute("errors", error);
            model.addAttribute("moviedto",dto);
        }
        return "/Movic.jsp";
    }
}

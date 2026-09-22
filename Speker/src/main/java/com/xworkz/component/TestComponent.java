package com.xworkz.component;


import com.xworkz.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestComponent {

    public TestComponent() {
        System.out.println("TestComponent started");
    }

    @RequestMapping("/click")
    public String onClick() {
        System.out.println("running click()");
        return "Test.jsp";
    }
    @RequestMapping("/team")
    public String Cricket(CricketTeamDTo dto, Model model){
        System.out.println("running the team method");
        System.out.println("Received DTO: "+dto);
model.addAttribute("sucssess","Team registered successfully!");
        return "/Cricket.jsp";
    }
    @RequestMapping("/product")
    public String product(ProductDTO dto ,Model model){
        System.out.println("running the product method");
        System.out.println("Received DTO: "+dto);
        model.addAttribute("sucssess","Product registered successfully!");
        return "/Product.jsp";
    }
    @RequestMapping("/place")
    public String place(PlaceDTO dto , Model model){
        System.out.println("running the place method");
        System.out.println("Received DTO: "+dto);
        model.addAttribute("sucssess","Place registered successfully!");
        return "/Place.jsp";
    }
    @RequestMapping("/contact")
    public String contact(ContactDTO dto , Model model){
        System.out.println("running the contact method");
        System.out.println("Received DTO: "+dto);
        model.addAttribute("sucssess","Contact registered successfully!");
        return "/Contect.jsp";
    }
    @RequestMapping("/movie")
    public String movie(MovieDTO dto , Model model){
        System.out.println("running the movie method");
        System.out.println("Received DTO: "+dto);
        model.addAttribute("sucssess","Movie registered successfully!");
        return "/Movic.jsp";
    }
    @RequestMapping("/telephone")
    public String telephone(TelephoneOperatorDTO dto , Model model){
        System.out.println("running the telephone method");
        System.out.println("Received DTO: "+dto);
        model.addAttribute("sucssess","Telephone registered successfully!");
        return "/Telephone.jsp";
    }


}

package com.xworkz.component;


import com.xworkz.dto.*;
import com.xworkz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class TestComponent {
    @Autowired
    private CricketTeamService cricketTeam;

    @Autowired
    private ProductService productService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private TelephoneOperatorService telephoneOperatorService;

    @Autowired
    private CameraService cameraService;

    @Autowired
    private MobileService mobileService;

    @Autowired
    private TempleService templeService;
    public TestComponent() {
        System.out.println("TestComponent started");
    }

    @RequestMapping("/click")
    public String onClick() {
        System.out.println("running click()");
        return "Test.jsp";
    }

    @RequestMapping("/team")
    public String Cricket(@Valid CricketTeamDTo dto, Model model, BindingResult bindingResult){
        System.out.println("running the team method");
        System.out.println("Received DTO: " + dto);
        if(bindingResult.hasErrors()) {
            System.out.println("no validection error"+bindingResult.getFieldErrorCount());
           cricketTeam.validetionAndSavd(dto);


        }else {
            cricketTeam.validetionAndSavd(dto);
            model.addAttribute("sucssess", "Team registered successfully!");
        }
        return "/Cricket.jsp";
    }
    @RequestMapping("/product")
    public String product(@Valid ProductDTO dto ,Model model,BindingResult bindingResult){

        System.out.println("running the product method");
        System.out.println("Received DTO: " + dto);
        if (bindingResult.hasErrors()) {


           productService.validectionAndSved(dto);


        }else {
            productService.validectionAndSved(dto);
            model.addAttribute("sucssess", "Product registered successfully!");

        }
        return "/Product.jsp";
    }
    @RequestMapping("/place")
    public String place(@Valid PlaceDTO dto , Model model,BindingResult bindingResult){
        System.out.println("running the place method");
        System.out.println("Received DTO: " + dto);
        if(bindingResult.hasErrors()) {



           placeService.vaalidetionAndSave(dto);
            model.addAttribute("sucssess", "Place registered successfully!");
        }else {
            model.addAttribute("error", "Validation failed. Please check the form.");
        }
        return "/Place.jsp";
    }
    @RequestMapping("/contact")
    public String contact(@Valid ContactDTO dto , Model model,BindingResult bindingResult){
        System.out.println("running the contact method");
        System.out.println("Received DTO: " + dto);
        if(bindingResult.hasErrors()) {

            this.contactService.validetionAndSavd(dto);
            model.addAttribute("sucssess", "Contact registered successfully!");
        }else {
            model.addAttribute("error", "Validation failed. Please check the form.");
        }
        return "/Contect.jsp";
    }
    @RequestMapping("/movie")
    public String movie(@Valid MovieDTO dto , Model model,BindingResult bindingResult){
        System.out.println("running the movie method");
        System.out.println("Received DTO: "+dto);
        if (bindingResult.hasErrors()){

      movieService.validetionAndSave(dto);
        model.addAttribute("sucssess","Movie registered successfully!");
        }else {
            model.addAttribute("error", "Validation failed. Please check the form.");
        }
        return "/Movic.jsp";
    }
    @RequestMapping("/telephone")
    public String telephone(@Valid TelephoneOperatorDTO dto , Model model,BindingResult bindingResult){
        System.out.println("running the telephone method");
        System.out.println("Received DTO: " + dto);
        if(bindingResult.hasErrors()) {

            telephoneOperatorService.validetionAndSave(dto);
            model.addAttribute("sucssess", "Telephone registered successfully!");
        }
        else {
            model.addAttribute("error", "Validation failed. Please check the form.");
        }
        return "/Telephone.jsp";
    }
    @RequestMapping("/camera")
    public String camera(@Valid CameraDTO dto , Model model,BindingResult bindingResult){
        System.out.println("running the camera method");
        System.out.println("Received DTO: "+dto);
        if(bindingResult.hasErrors()){

       cameraService.validetionAndSave(dto);

        model.addAttribute("sucssess","Camera registered successfully!");
        }
        else {
            model.addAttribute("error", "Validation failed. Please check the form.");
        }
        return "/Camera.jsp";
    }
    @RequestMapping("/mobile")
    public String mobile(@Valid MobileDTO dto , Model model,BindingResult bindingResult){
        System.out.println("running the mobile method");
        System.out.println("Received DTO: " + dto);
        if(bindingResult.hasErrors()) {

           mobileService.validetionAndSave(dto);
            model.addAttribute("sucssess", "Mobile registered successfully!");
        }else {
            model.addAttribute("error", "Validation failed. Please check the form.");
        }
        return "/Mobile.jsp";
    }
    @RequestMapping("/temple")
    public String temple(@Valid TempleDTO dto , Model model,BindingResult bindingResult){
        System.out.println("running the temple method");
        System.out.println("Received DTO: " + dto);
        if(bindingResult.hasErrors()) {

           templeService.validetionAndSave(dto);
            model.addAttribute("sucssess", "Temple registered successfully!");
        }else {
            model.addAttribute("error", "Validation failed. Please check the form.");
        }
        return "/Temple.jsp";
    }



}

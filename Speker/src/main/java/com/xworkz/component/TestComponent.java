package com.xworkz.component;


import com.xworkz.dto.*;
import com.xworkz.service.*;
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
    public String Cricket(Model model ,@Valid CricketTeamDTo dto, BindingResult bindingResult){
        System.out.println("running the team method");
        System.out.println("Received DTO: " + dto);
        if(!bindingResult.hasErrors()) {
            System.out.println("no validection error");
           cricketTeam.validetionAndSavd(dto);
            model.addAttribute("sucssess", "Team registered successfully!");

        }else {
            System.out.println("valid error pliz fix it");
            List<ObjectError> error = bindingResult.getAllErrors();
            model.addAttribute("errors", error);

            model.addAttribute("cricketdto"+dto);
          model.addAttribute("error", "Team registration failed. Please check the form.");
        }
        return "/Cricket.jsp";
    }
    @RequestMapping("/product")
    public String product(Model model,@Valid ProductDTO dto ,BindingResult bindingResult){

        System.out.println("running the product method");
        System.out.println("Received DTO: " + dto);
        if (bindingResult.hasErrors()) {

            System.out.println("validet error plize fix it: ");
           productService.validectionAndSved(dto);
            List<ObjectError> error = bindingResult.getAllErrors();
model.addAttribute("errors", error);

model.addAttribute("productdto"+dto);
        }else {
            System.out.println("validet dtat succsesfull");
            model.addAttribute("sucssess", "Product registered successfully!");

        }
        return "/Product.jsp";
    }
    @RequestMapping("/place")
    public String place(Model model,@Valid PlaceDTO dto , BindingResult bindingResult){
        System.out.println("running the place method");
        System.out.println("Received DTO: " + dto);
        if(bindingResult.hasErrors()) {


            System.out.println("vaklide  error plize pix: ");
           placeService.vaalidetionAndSave(dto);
            model.addAttribute("error", "Validation failed. Please check the form.");
            List<ObjectError> error = bindingResult.getAllErrors();
            model.addAttribute("errors", error);

            model.addAttribute("placedto"+dto);
            System.out.println("PlaceDTO: " + bindingResult.getAllErrors());
        }else {
            System.out.println("validet dtos data");

            model.addAttribute("sucssess", "Place registered successfully!");

        }
        return "/Place.jsp";
    }
    @RequestMapping("/contact")
    public String contact(Model model,@Valid ContactDTO dto , BindingResult bindingResult){
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
            model.addAttribute("contactdto"+dto);
        }
        return "/Contect.jsp";
    }
    @RequestMapping("/movie")
    public String movie(Model model,@Valid MovieDTO dto , BindingResult bindingResult){
        System.out.println("running the movie method");
        System.out.println("Received DTO: "+dto);
        if (!bindingResult.hasErrors()){
            System.out.println("dtat valide: ");
      movieService.validetionAndSave(dto);
        model.addAttribute("sucssess","Movie registered successfully!");
        }else {
            System.out.println("dtat invalide: ");
            model.addAttribute("error", "Validation failed. Please check the form.");
        }
        return "/Movic.jsp";
    }
    @RequestMapping("/telephone")
    public String telephone( Model model,@Valid TelephoneOperatorDTO dto ,BindingResult bindingResult){
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
            model.addAttribute("telephonedto"+dto);
        }
        return "/Telephone.jsp";
    }
    @RequestMapping("/camera")
    public String camera(Model model,@Valid CameraDTO dto , BindingResult bindingResult){
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
            model.addAttribute("cameradto"+dto);
        }
        return "/Camera.jsp";
    }
    @RequestMapping("/mobile")
    public String mobile( Model model,@Valid MobileDTO dto ,BindingResult bindingResult){
        System.out.println("running the mobile method");
        System.out.println("Received DTO: " + dto);
        if(!bindingResult.hasErrors()) {
            System.out.println("valid data: ");
           mobileService.validetionAndSave(dto);
            model.addAttribute("sucssess", "Mobile registered successfully!");
        }else {
            System.out.println("invalid data: ");
            model.addAttribute("error", "Validation failed. Please check the form.");
            List<ObjectError> error = bindingResult.getAllErrors();
            model.addAttribute("errors", error);
            model.addAttribute("mobile dto"+dto);
        }
        return "/Mobile.jsp";
    }
    @RequestMapping("/temple")
    public String temple(Model model,@Valid TempleDTO dto , BindingResult bindingResult){
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
            model.addAttribute("templ dto"+dto);
        }
        return "/Temple.jsp";
    }



}

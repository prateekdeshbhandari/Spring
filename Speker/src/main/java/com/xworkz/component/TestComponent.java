package com.xworkz.component;


import com.xworkz.dto.*;
import com.xworkz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String Cricket(CricketTeamDTo dto, Model model){
        System.out.println("running the team method");
        System.out.println("Received DTO: "+dto);
        this.cricketTeam.validetionAndSavd(dto);
model.addAttribute("sucssess","Team registered successfully!");
        return "/Cricket.jsp";
    }
    @RequestMapping("/product")
    public String product(ProductDTO dto ,Model model){
        System.out.println("running the product method");
        System.out.println("Received DTO: "+dto);
        this.productService.validectionAndSved(dto);

        model.addAttribute("sucssess","Product registered successfully!");
        return "/Product.jsp";
    }
    @RequestMapping("/place")
    public String place(PlaceDTO dto , Model model){
        System.out.println("running the place method");
        System.out.println("Received DTO: "+dto);
        this.placeService.vaalidetionAndSave(dto);
        model.addAttribute("sucssess","Place registered successfully!");
        return "/Place.jsp";
    }
    @RequestMapping("/contact")
    public String contact(ContactDTO dto , Model model){
        System.out.println("running the contact method");
        System.out.println("Received DTO: "+dto);
        this.contactService.validetionAndSavd( dto);
        model.addAttribute("sucssess","Contact registered successfully!");
        return "/Contect.jsp";
    }
    @RequestMapping("/movie")
    public String movie(MovieDTO dto , Model model){
        System.out.println("running the movie method");
        System.out.println("Received DTO: "+dto);
        this.movieService.validetionAndSave(dto);
        model.addAttribute("sucssess","Movie registered successfully!");
        return "/Movic.jsp";
    }
    @RequestMapping("/telephone")
    public String telephone(TelephoneOperatorDTO dto , Model model){
        System.out.println("running the telephone method");
        System.out.println("Received DTO: "+dto);
        this.telephoneOperatorService.validetionAndSave(dto);
        model.addAttribute("sucssess","Telephone registered successfully!");
        return "/Telephone.jsp";
    }
    @RequestMapping("/camera")
    public String camera(CameraDTO dto , Model model){
        System.out.println("running the camera method");
        System.out.println("Received DTO: "+dto);
        this.cameraService.validetionAndSave(dto);

        model.addAttribute("sucssess","Camera registered successfully!");
        return "/Camera.jsp";
    }
    @RequestMapping("/mobile")
    public String mobile(MobileDTO dto , Model model){
        System.out.println("running the mobile method");
        System.out.println("Received DTO: "+dto);
        this.mobileService.validetionAndSave(dto);
        model.addAttribute("sucssess","Mobile registered successfully!");
        return "/Mobile.jsp";
    }
    @RequestMapping("/temple")
    public String temple(TempleDTO dto , Model model){
        System.out.println("running the temple method");
        System.out.println("Received DTO: "+dto);
        this.templeService.validetionAndSave(dto);
        model.addAttribute("sucssess","Temple registered successfully!");
        return "/Temple.jsp";
    }



}

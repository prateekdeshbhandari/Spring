package com.xworkz.Inventar.restController;

import com.xworkz.Inventar.Service.RegisterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class RegisterRestController {
    private RegisterService service;

    @GetMapping("/checkEmailExit/{email:.+}")
    public String checkEmailExit(@PathVariable("email") String email) {
        System.out.println("Controller email: [" + email + "]");
        return service.findEmail(email);
    }

    @GetMapping("/checkPhoneNumber/{phoneNumber:.+}")
    public String checkPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {

        System.out.println("Invoking checkPhoneNumber: " + phoneNumber);

        return service.findPhoneNumber(phoneNumber);
    }


    @GetMapping("/checkLoginEmail/{email:.+}")
    public String checkLoginEmail(@PathVariable("email") String email) {

        System.out.println("Checking login email: [" + email + "]");
        return service.findEmail(email);
    }
}

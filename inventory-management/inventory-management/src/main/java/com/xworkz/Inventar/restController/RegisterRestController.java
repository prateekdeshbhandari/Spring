package com.xworkz.Inventar.restController;

import com.xworkz.Inventar.Service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@AllArgsConstructor
public class RegisterRestController {

    private RegisterService service;

    @GetMapping("/checkEmailExit/{email:.+}")
    @ResponseBody
    public String checkEmailExit(@PathVariable("email") String email) {
        System.out.println("Controller email: [" + email + "]");
        return service.findEmail(email);
    }

    @GetMapping("/checkPhoneNumber/{phoneNumber:.+}")
    @ResponseBody
    public String checkPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {

        System.out.println("Invoking checkPhoneNumber: " + phoneNumber);

        return service.findPhoneNumber(phoneNumber);
    }



}
package com.xworkz.Inventar.restController;

import com.xworkz.Inventar.Service.RegisterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/api/inventory")
@AllArgsConstructor
public class RegisterRestController {

    private RegisterService service;

    @GetMapping("/checkEmailExit/{email:.+}")
    @ResponseBody
    public String checkEmailExit(@PathVariable("email") String email) {
        log.info("Controller email: [" + email + "]");

        boolean exists = Boolean.parseBoolean(service.findEmail(email));

        return exists ? "false" : "true";
    }

    @GetMapping("/checkPhoneNumber/{phoneNumber:.+}")
    @ResponseBody
    public String checkPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {


        boolean exists = Boolean.parseBoolean(service.findPhoneNumber(phoneNumber));

        return exists ? "false" : "true";
    }
    @GetMapping("fogetPassword")
    public String fogetPassword() {
        return "fogetPassword";
    }

    @PostMapping("changPassword")
    @ResponseBody
    public String changPassword(@RequestParam("email")String email) {
        log.info("Controller changPassword"+email);
        boolean sent=service.fogetPassword(email);
        if(sent){
            return "true";
        }

        return "fogetPassword";
    }


}
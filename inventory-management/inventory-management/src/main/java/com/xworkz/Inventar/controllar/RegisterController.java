package com.xworkz.Inventar.controllar;

import com.xworkz.Inventar.Service.RegisterService;
import com.xworkz.Inventar.dto.LoginDto;
import com.xworkz.Inventar.dto.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    public RegisterController(){
        System.out.println("Created RegisterController...");
    }
    @GetMapping()
    public String onLoadRegister(Model model){
        System.out.println("Running onLoadRegister in RegisterController...");
        model.addAttribute("registerDTO", new RegisterDTO());
        return "Register";
    }

    @PostMapping()
    public String saveRegisterForm(@ModelAttribute @Valid RegisterDTO registerDTO, Model model) {

        System.out.println("Running saveRegisterForm()");
        System.out.println("RegisterDTO: " + registerDTO);

        String message = registerService.registerService(registerDTO);

        if ("Registration Successful".equals(message)) {
            model.addAttribute("successMessage", message);
            model.addAttribute("RegisterDto", new RegisterDTO());
        } else {
            model.addAttribute("errorMessage", message);
            model.addAttribute("RegisterDto", registerDTO);
        }

        return "Register";
    }

    @GetMapping("/login")
    public String onLoadLogin(Model model){
        System.out.println("Running onLoadLogin in RegisterController...");
        model.addAttribute("loginDTO", new RegisterDTO());
        return "Login";
    }
    @PostMapping("/login")
    public String login(LoginDto loginDto, Model model) {
        System.out.println("Login method is called: " + loginDto);
        RegisterDTO dto = registerService.loginService(loginDto);
        System.out.println("DTO: " + dto);

        if (dto != null) {
            model.addAttribute("registerDto", dto);
            return "dashboard";
        }

        model.addAttribute("msg", "Login Failed. Please check your email and password.");
        model.addAttribute("loginDto", loginDto);

        return "Login";
    }
    @GetMapping("/edit")
    public String editProfile(@RequestParam("email") String email, Model model) {
        System.out.println("Edit method is called: " + email);
        RegisterDTO dto = registerService.findUserByEmail(email);

        if (dto == null) {
            model.addAttribute("msg", "User not found");
            return "editProfile";
        }

        model.addAttribute("registerDto", dto);
        return "editProfile";
    }

    @PostMapping("/update")
    public String updateProfile(
            @ModelAttribute RegisterDTO registerDTO,
            Model model) {

        System.out.println("Update method is called: " + registerDTO);

        boolean updated = registerService.updateProfile(registerDTO);

        if (updated) {
            RegisterDTO dto =
                    registerService.findUserByEmail(registerDTO.getEmail());

            model.addAttribute("registerDto", dto);
            return "dashboard";
        }

        model.addAttribute("registerDto", registerDTO);
        model.addAttribute("msg", "Profile update failed");

        return "editProfile";
    }
}




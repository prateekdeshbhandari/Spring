package com.xworkz.Inventar.controllar;

import com.xworkz.Inventar.Service.RegisterService;
import com.xworkz.Inventar.dto.LoginDto;
import com.xworkz.Inventar.dto.RegisterDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/register")
@Slf4j
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    public RegisterController(){
        System.out.println("Created RegisterController...");
    }
    @GetMapping()
    public String onLoadRegister(Model model){
        log.info("Running onLoadRegister in RegisterController...");
        model.addAttribute("registerDTO", new RegisterDTO());
        return "Register";
    }

    @PostMapping()
    public String saveRegisterForm(@ModelAttribute @Valid RegisterDTO registerDTO, Model model) {

        log.info("Running saveRegisterForm()");
        log.info("RegisterDTO: " + registerDTO);

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
        log.info("Running onLoadLogin in RegisterController...");
        model.addAttribute("loginDTO", new RegisterDTO());
        return "Login";
    }
    @PostMapping("/login")
    public String login(LoginDto loginDto, Model model) {
        log.info("Login method is called: " + loginDto);
        RegisterDTO dto = registerService.loginService(loginDto);
        log.info("DTO: " + dto);

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
        log.info("Edit method is called: " + email);
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

        log.info("Update method is called: " + registerDTO);

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

    @PostMapping("/updateImage")
    public String updateProfileImage(
            @RequestParam("email") String email,
            @RequestParam("file") MultipartFile file,
            Model model) {

        log.info("Update image method is called for: " + email);

        boolean updated = registerService.updateProfileImage(email, file);

        RegisterDTO dto = registerService.findUserByEmail(email);
        model.addAttribute("registerDto", dto);

        if (updated) {
            model.addAttribute("successMessage", "Profile image updated successfully");
        } else {
            model.addAttribute("msg", "Profile image update failed. Please choose a valid image (max 2 MB).");
        }

        return "dashboard";
    }
    @GetMapping("/userLogin")
    public String sendEmail() {
        log.info("Send email method is called");
        return "userLogin";
    }
    @PostMapping("/userLogin")
    public String sendEmail(@ModelAttribute LoginDto loginDto, Model model) {
        log.info("Send email method is called");
        model.addAttribute("email", loginDto.getEmail());
        model.addAttribute("otp succsesfull", "otp");
        registerService.sendEmail(loginDto.getEmail());
        return "otpLogin";
    }
    @PostMapping("/verifyOtp")
    public String verifyOtp(@RequestParam String email, @RequestParam String otp, Model model) {
        log.info("Verify OTP method is called");
        log.info("Email: " + email + ", OTP: " + otp);
        
        RegisterDTO dto = registerService.verifyOtp(email, otp);
        
        if (dto != null) {
            model.addAttribute("registerDto", dto);
            return "dashboard";
        } else {
            model.addAttribute("error", "Invalid OTP");
            model.addAttribute("email", email);
            return "otpLogin";
        }
    }

        @PostMapping("resendOtp")
                public String resendOtp(@ModelAttribute LoginDto dto, Model model) {
            log.info("Resend OTP method is called");
            model.addAttribute("registerDto", dto);
            registerService.sendEmail(dto.getEmail());
            return "otpLogin";
        }
    @GetMapping("/fogetPassword")
    public String forgotPassword() {
        return "fogetPassword";
    }

    @PostMapping("/sendResetLink")
    @ResponseBody
    public String sendResetLink(@RequestParam("email") String email) {
        log.info("sendResetLink controller reached. Email: {}", email);
        boolean sent = registerService.fogetPassword(email);
        return sent ? "Reset link sent to your email." : "Unable to send reset link.";
    }
    @GetMapping("/resetPassword")
    public String resetPasswordPage(@RequestParam("token") String token,
                                    Model model) {

        model.addAttribute("token", token);
        return "resetPassword";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam("token") String token, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword, Model model) {

        if (password == null || password.trim().length() < 8) {
            model.addAttribute("token", token);
            model.addAttribute("msg", "Password must be at least 8 characters.");
            return "resetPassword";
        }

        if (!password.equals(confirmPassword)) {
            model.addAttribute("token", token);
            model.addAttribute("msg", "Passwords do not match.");
            return "resetPassword";
        }

        boolean updated = registerService.resetPassword(token, password);

        if (updated) {
            model.addAttribute("msg",
                    "Password reset successfully. Please login.");
            return "Login";
        }

        model.addAttribute("msg", "Reset link is invalid or expired. Please request a new link.");

        return "fogetPassword";
    }

    @GetMapping("/displayImage")
    public ResponseEntity<byte[]> displayImage(@RequestParam("imageName") String imageName) {

        Path uploadDir = Paths.get("src/main/webapp/uploads").toAbsolutePath().normalize();
        Path imagePath = uploadDir.resolve(imageName).normalize();

        if (!imagePath.startsWith(uploadDir) || !Files.exists(imagePath)) {
            return ResponseEntity.notFound().build();
        }

        try {
            byte[] imageBytes = Files.readAllBytes(imagePath);
            String contentType = Files.probeContentType(imagePath);
            if (contentType == null) {
                contentType = MediaType.IMAGE_JPEG_VALUE;
            }

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, contentType)
                    .body(imageBytes);

        } catch (IOException e) {
            log.error("Failed to read profile image: {}", imageName, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}




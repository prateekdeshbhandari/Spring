package com.xworkz.Inventar.Service;

import com.xworkz.Inventar.dto.LoginDto;
import com.xworkz.Inventar.dto.RegisterDTO;
import org.springframework.web.multipart.MultipartFile;

public interface RegisterService {
   String registerService(RegisterDTO dto);
    String findEmail(String email);
    String findPhoneNumber(String phoneNumber);
    RegisterDTO loginService(LoginDto dto);
    RegisterDTO findUserByEmail(String email);
    boolean updateProfile(RegisterDTO registerDTO);
    boolean updateProfileImage(String email, MultipartFile file);
    boolean sendEmail(String email);
    RegisterDTO verifyOtp(String email, String otp);
    boolean fogetPassword(String email);
    boolean resetPassword(String email, String newPassword);


}

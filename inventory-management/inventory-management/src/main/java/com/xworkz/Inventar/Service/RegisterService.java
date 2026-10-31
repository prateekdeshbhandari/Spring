package com.xworkz.Inventar.Service;

import com.xworkz.Inventar.dto.LoginDto;
import com.xworkz.Inventar.dto.RegisterDTO;

public interface RegisterService {
   String registerService(RegisterDTO dto);
    String findEmail(String email);
    String findPhoneNumber(String phoneNumber);
    RegisterDTO loginService(LoginDto dto);
    RegisterDTO findUserByEmail(String email);
    boolean updateProfile(RegisterDTO registerDTO);


}

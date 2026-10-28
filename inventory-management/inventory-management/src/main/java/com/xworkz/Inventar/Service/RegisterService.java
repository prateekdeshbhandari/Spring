package com.xworkz.Inventar.Service;

import com.xworkz.Inventar.dto.LoginDto;
import com.xworkz.Inventar.dto.RegisterDTO;

public interface RegisterService {
    boolean registerService(RegisterDTO dto);
    RegisterDTO loginService(LoginDto dto);
}

package com.xworkz.Inventar.refo;

import com.xworkz.Inventar.entity.RegisterEntity;

public interface RegisterRepository {
   void rejestarRefo(RegisterEntity registerEntity);

   boolean emailExists(String email);
   boolean phoneNumberExists(String phoneNumber);

   RegisterEntity findEntityByEmail(String email);
   void update(RegisterEntity entity);
   boolean saveOtp(String email, String otp);
    RegisterEntity findEntityByResetToken(String resetToken);

}

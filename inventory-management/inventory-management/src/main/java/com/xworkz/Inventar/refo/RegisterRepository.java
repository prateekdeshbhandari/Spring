package com.xworkz.Inventar.refo;

import com.xworkz.Inventar.entity.RegisterEntity;

public interface RegisterRepository {
   void rejestarRefo(RegisterEntity registerEntity);
   RegisterEntity findByEmail(String email);
   RegisterEntity findByPassword( String password);

}

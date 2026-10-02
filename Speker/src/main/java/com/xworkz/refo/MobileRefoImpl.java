package com.xworkz.refo;

import com.xworkz.dto.MobileDTO;
import org.springframework.stereotype.Repository;

@Repository
public class MobileRefoImpl implements MobileRefo{
    @Override
    public boolean saved(MobileDTO dto) {
        System.out.println("mobile dto is saved..");
        return true;
    }
}

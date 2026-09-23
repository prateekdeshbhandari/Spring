package com.xworkz.service;

import com.xworkz.dto.CricketTeamDTo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component

public class CricketTeamIMPL implements CricketTeamService {
    public CricketTeamIMPL(){
        System.out.println("validection CricketTeamIMPL start...");
    }
    @Override
    public boolean validetionAndSavd(CricketTeamDTo dto) {
        System.out.println("valideting dtos");


        return true;
    }
}

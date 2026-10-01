package com.xworkz.component;

import com.xworkz.dto.CricketTeamDTo;
import com.xworkz.service.CricketTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class CricketComponent {
    @Autowired
    private CricketTeamService cricketTeam;

    @RequestMapping("/team")
    public String cricket(Model model , @Valid CricketTeamDTo dto, BindingResult bindingResult){
        System.out.println("running the team method");
        System.out.println("Received DTO: " + dto);
        if(!bindingResult.hasErrors()) {
            System.out.println("no validection error");
            cricketTeam.validetionAndSavd(dto);
            model.addAttribute("sucssess", "Team registered successfully!");

        }else {
            System.out.println("valid error pliz fix it");
            List<ObjectError> error = bindingResult.getAllErrors();
            model.addAttribute("errors", error);

            model.addAttribute("cricketdto",dto);
            model.addAttribute("error", "Team registration failed. Please check the form.");
        }
        return "/Cricket.jsp";
    }
}

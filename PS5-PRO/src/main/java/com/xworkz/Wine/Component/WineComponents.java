package com.xworkz.Wine.Component;

import com.xworkz.Wine.dto.WineDTO;
import com.xworkz.Wine.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/wine")
public class WineComponents {
    @Autowired
    private WineService wineService;

    public void WineController() {
        System.out.println("WineController create");
    }


    @PostMapping
    public String onWineSubmit(Model model, @Valid WineDTO wineDTO, BindingResult bindingResult) {

        System.out.println("running onWineSubmit()");

        if (bindingResult.hasErrors()) {

            System.out.println("There are validation errors, please fix it");

            List<ObjectError> errors = bindingResult.getAllErrors();

            model.addAttribute("validationErrors", errors);
            model.addAttribute("wineDTO", wineDTO);

        } else {

            model.addAttribute("message", "Wine registered successfully");

            System.out.println("no validation errors");
            System.out.println(wineDTO);

            this.wineService.validateAndSave(wineDTO);

            model.addAttribute("wineDTO", new WineDTO());
        }

        return "Wine";
    }


    @GetMapping("/showAll")
    public String getShowAll(Model model) {
        System.out.println("running getShowAll()");

        List<WineDTO> wineDTOList = this.wineService.getShowAlll();
        model.addAttribute("wineDTOList", wineDTOList);

        return "WineDisplay";
    }

    @GetMapping("/edit")
    public String getEdit(@RequestParam("id") Integer id, Model model) {
        System.out.println("running getEdit()");
        WineDTO wineDTO = this.wineService.getEdit(id);
        if (wineDTO != null) {
            model.addAttribute("wineDTO", wineDTO);
        } else {
            model.addAttribute("error", "Wine not found with ID: " + id);
        }

        return "Wine";
    }

    @PostMapping("/update")
    public String onUpdate(Model model, @Valid WineDTO wineDTO, BindingResult bindingResult) {
        System.out.println("running onUpdate()");

        if (bindingResult.hasErrors()) {
            System.out.println("There are validation errors, please fix it");
            List<ObjectError> errors = bindingResult.getAllErrors();
            model.addAttribute("validationErrors", errors);
            model.addAttribute("wineDTO", wineDTO);
            return "Wine";
        } else {
            model.addAttribute("message", "Wine updated successfully");
            System.out.println("no validation errors");
            System.out.println(wineDTO);
            this.wineService.validateAndUpdate(wineDTO);
            model.addAttribute("wineDTO", new WineDTO());
            return "redirect:/wine/showAll";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        System.out.println("running delete() with id: " + id);
        this.wineService.delete(id);
        return "redirect:/wine/showAll";
    }
}


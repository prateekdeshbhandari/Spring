package com.xworkz.component;

import com.xworkz.dto.ProductDTO;
import com.xworkz.service.ProductService;
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
public class ProductComponent {

    @Autowired
    private ProductService productService;
    @RequestMapping("/product")
    public String product(Model model, @Valid ProductDTO dto , BindingResult bindingResult){
        System.out.println("running the product method");
        System.out.println("Received DTO: " + dto);
        if (bindingResult.hasErrors()) {

            System.out.println("validet error plize fix it: ");
            productService.validectionAndSved(dto);
            List<ObjectError> error = bindingResult.getAllErrors();
            model.addAttribute("errors", error);

            model.addAttribute("productdto",dto);
        }else {
            System.out.println("validet dtat succsesfull");
            model.addAttribute("sucssess", "Product registered successfully!");

        }
        return "/Product.jsp";
    }
}

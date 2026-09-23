package com.xworkz.service;

import com.xworkz.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService{
    public ProductServiceImpl(){
        System.out.println("validetcion ProductServiceImpl start...");
    }
    @Override
    public boolean validectionAndSved(ProductDTO dto) {
        System.out.println("Valideted");

        return true;
    }
}

package com.xworkz.service;

import com.xworkz.dto.MovieDTO;
import org.springframework.stereotype.Component;

@Component
public class MovieServiceImpl implements MovieService{
    @Override
    public boolean validetionAndSave(MovieDTO dto) {
        System.out.println("MovieServiceImpl validetionAndSave method");
        return true;
    }
}

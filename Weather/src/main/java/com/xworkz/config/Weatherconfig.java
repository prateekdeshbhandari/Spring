package com.xworkz.config;

import com.xworkz.component.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(" com.xworkz.component")
public class Weatherconfig
{
    public Weatherconfig(){
        System.out.println("create Weatherconfig");
    }
@Bean
    public  Shield shield(){



        Shield shielda = new Shield();
        System.out.println("Shield created");
return shielda;
    }
    @Bean
    public String name(){
        System.out.println("Name created");
        return "Xworkz";
    }

    @Bean
    public String location(){
        System.out.println("Location created");
        return "BTM";
    }
    @Bean
    public  Long phone(){
        System.out.println("Phone created");
        return 1234567890L;
    }

    @Bean
    public Toy toy(){
        Toy toy=new Toy();
        System.out.println("Toy created");
        return toy;
    }
    @Bean
    public Paint paint(){
        Paint paint=new Paint();
        System.out.println("Paint created");
        return paint;
    }
    @Bean
    public Camera camera(){
        Camera camera=new Camera();
        System.out.println("Camera created");
        return camera;
    }
    @Bean
    public String brand(){
        System.out.println("Brand created");
        return "Canon";

    }
    @Bean
    public Ganesha ganesha(){
        Ganesha ganesha=new Ganesha();
        System.out.println("Ganesha created");
        return  ganesha;
    }
    @Bean
    public Elephan elephant(){
        Elephan elephan=new Elephan();
        System.out.println("Elephan created");
        return elephan;
    }
}

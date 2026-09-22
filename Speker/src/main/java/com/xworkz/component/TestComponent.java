package com.xworkz.component;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestComponent {

    public TestComponent() {
        System.out.println("TestComponent started");
    }

    @RequestMapping("/click")
    public String onClick() {
        System.out.println("running click()");
        return "Test.jsp";
    }
}

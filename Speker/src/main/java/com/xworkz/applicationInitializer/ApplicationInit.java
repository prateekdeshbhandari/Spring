package com.xworkz.applicationInitializer;


import com.xworkz.configuration.ApplicationConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ApplicationConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/click","/team","/product","/place","/contact","/movie","/telephone","/camera","/mobile","/temple"};
    }
}

//These two dependencies are used for validation in Java/Spring MVC applications. They work together.

//dto using validection
//<dependency>
//    <groupId>javax.validation</groupId>
//    <artifactId>validation-api</artifactId>
//    <version>2.0.1.Final</version>
//</dependency>

//validation-api
//       ↓
//Defines @NotNull, @Size, @Email, etc.
//       ↓
//hibernate-validator
//       ↓
//Actually checks whether the values satisfy those rules
//<dependency>
//    <groupId>org.hibernate.validator</groupId>
//    <artifactId>hibernate-validator</artifactId>
//    <version>6.2.5.Final</version>
////</dependency>




//The JSTL dependency is used in JSP to make your pages easier to write by providing ready-made tags for common tasks like loops,
// conditions, formatting, and working with data.
//<dependency>
//    <groupId>javax.servlet</groupId>
//    <artifactId>jstl</artifactId>
//    <version>1.2</version>
//</dependency>

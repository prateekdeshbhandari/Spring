package com.xworkz.PS5.ApplicationInit;

import com.xworkz.PS5.Config.AplicetionConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AplicetionConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/PS5"};
    }
}

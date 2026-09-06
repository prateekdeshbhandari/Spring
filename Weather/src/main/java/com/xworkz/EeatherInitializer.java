package com.xworkz;

import com.xworkz.config.Weatherconfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class EeatherInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{Weatherconfig.class, Weatherconfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}

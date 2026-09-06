package com.xworkz;

import com.xworkz.config.ContectConfig;
import com.xworkz.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ContectInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ContectConfig.class, WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}

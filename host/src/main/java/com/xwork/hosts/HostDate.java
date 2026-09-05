package com.xwork.hosts;

import com.xwork.hosts.config.DatabaseConfiguretion;
import com.xwork.hosts.config.SpringConfugertion;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public  class HostDate extends AbstractAnnotationConfigDispatcherServletInitializer {
public HostDate(){

    System.out.println("Created HostDate...");
}

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfugertion.class, DatabaseConfiguretion.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}

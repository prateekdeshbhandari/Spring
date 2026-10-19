package com.xworkz.Inventar.config;

import lombok.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement

public class ApplictionDataConfig {

//    @Value("${jdbc.driver_class_name}")
//    private String driverClassName;
//
//    @Value("${jdbc.url}")
//    private String url;
//
//    @Value("${jdbc.username}")
//    private String username;
//
//    @Value("${jdbc.password}")
//    private String password;


    public ApplictionDataConfig() {
        System.out.println("DatabaseConfiguration() created");
    }


    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/inventory_management");
        dataSource.setUsername("root");
        dataSource.setPassword("Prateek@#1");


        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

        System.out.println("running entityManagerFactory()");
        System.out.println("internally creating EntityManagerFactory of JPA");

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPackagesToScan("com.xworkz.Inventar.entity");

        // Hibernate
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

        System.out.println("running transactionManager()");
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }
}


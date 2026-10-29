package com.xworkz.Inventar.config;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
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

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource()
    {
        System.out.println("Running dataSource() in DataBaseConfiguration");
        DriverManagerDataSource dataSource=new DriverManagerDataSource();

        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));


//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/poc");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public Properties properties()
    {
        System.out.println("Running properties() in DataBaseConfiguration");

        Properties properties = new Properties();

        properties.setProperty(
                "hibernate.dialect",
                "org.hibernate.dialect.MySQL8Dialect");

        properties.setProperty(
                "hibernate.hbm2ddl.auto",
                environment.getProperty(
                        "spring.jpa.hibernate.ddl-auto", "update"));

        properties.setProperty(
                "hibernate.show_sql",
                environment.getProperty(
                        "spring.jpa.show-sql", "true"));

        properties.setProperty(
                "hibernate.format_sql",
                environment.getProperty(
                        "spring.jpa.hibernate.format_sql", "true"));

        return properties;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource)
    {
        System.out.println(
                "Running entityManagerFactoryBean() in DatabaseConfiguration");

        LocalContainerEntityManagerFactoryBean factoryBean =
                new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(dataSource);

        factoryBean.setPackagesToScan(
                "com.xworkz.Inventar.entity");

        factoryBean.setJpaVendorAdapter(
                new HibernateJpaVendorAdapter());

        factoryBean.setJpaProperties(properties());

        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory)
    {
        System.out.println(
                "Running transactionManager() in DatabaseConfiguration");

        JpaTransactionManager transactionManager =
                new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(
                entityManagerFactory);

        return transactionManager;
    }
}



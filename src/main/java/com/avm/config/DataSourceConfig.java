package com.avm.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.driver.class}")
    private String driverName;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;
    
    @Bean
    public DataSource getDataSource(){
        // DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        // dataSourceBuilder.driverClassName(driverName);
        // dataSourceBuilder.username(username);
        // dataSourceBuilder.password(password);
        // dataSourceBuilder.url(dbUrl);

        return DataSourceBuilder.create().build();
    }
}

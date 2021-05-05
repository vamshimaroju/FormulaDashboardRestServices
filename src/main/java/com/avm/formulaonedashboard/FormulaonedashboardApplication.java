package com.avm.formulaonedashboard;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = {"com.avm.*"})
@EnableJpaRepositories(basePackages = "com.avm.repositories")
@EntityScan(basePackages = "com.avm.entities")
@EnableTransactionManagement
@EnableJpaAuditing
// @EnableJpaRepositories
public class FormulaonedashboardApplication extends SpringBootServletInitializer {

		// private static ApplicationContext apCtx;

	public static void main(String[] args) {
		 SpringApplication.run(FormulaonedashboardApplication.class, args);
		System.out.println("welcome");	

	}

	// @Override
	// protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	// 	return application.sources(FormulaonedashboardApplication.class);
	// }

}

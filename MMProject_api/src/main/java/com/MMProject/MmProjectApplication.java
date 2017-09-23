package com.MMProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@SpringBootApplication
@ComponentScan({"com.controllers,com.services,com.service_Impls,com.security"})
@EntityScan("com.entities")
@EnableJpaRepositories("com.repositories")
public class MmProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmProjectApplication.class, args);
	}
	
}

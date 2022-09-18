package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.helpinghands.pojo.Admin;
import com.helpinghands.services.AdminService;

//@SpringBootApplication
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@ComponentScan(basePackages={"com.helpinghands.controller","com.helpinghands.servicesImpl"})
@ComponentScan({"com.helpinghands.response"})
@EntityScan("com.helpinghands.pojo")
@EnableJpaRepositories("com.helpinghands.repository")
//@EnableJpaAuditing
public class HelpingHandsBackendApplication {

private static final Logger log = LoggerFactory.getLogger(HelpingHandsBackendApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HelpingHandsBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AdminService srv) {
	    return (args) -> {
	    	if(srv.countAdmin()==0) {
	    		Admin admin=new Admin();
	    		admin.setEmail("admin@gmail.com");
	    		admin.setPwd("admin");
	    		admin.setUname("Administrator");
	    		srv.updateAdmin(admin);
	    		log.info("Admin user created successfully");
	    	}
	    };
	}

}

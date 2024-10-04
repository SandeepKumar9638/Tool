package com.example.ManagementTool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

public class ManagementToolApplication //implements CommandLineRunner 
{

	@Autowired
	ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		SpringApplication.run(ManagementToolApplication.class, args);
	}

/*	@Override
	public void run(String... args) throws Exception {
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beanDefinitionNames);
		System.out.println("beans calling");
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
	}*/

}

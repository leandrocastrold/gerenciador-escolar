package br.com.leandro.portalingles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.leandro.portalingles"})
public class PortalinglesApplication  {

	public static void main(String[] args)  {
		SpringApplication.run(PortalinglesApplication.class, args);
	}

}

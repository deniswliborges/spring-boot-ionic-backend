package com.deniswillian.cursomcc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursomccApplication implements CommandLineRunner{
	
	//@Autowired
	//private S3Service s3Service;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomccApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
		//s3Service.uploadFile("C:\\Users\\Administrador\\Documents\\PARTICULARES\\SpringBoot\\fotos\\ana.jpg");
	}	

}

package com.imd.medical_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MedicalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalApiApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("imd@2023"));
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }

}

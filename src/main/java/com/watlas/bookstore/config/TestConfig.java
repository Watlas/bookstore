package com.watlas.bookstore.config;

import com.watlas.bookstore.services.DBservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBservice DBservice;

    @Bean
    public void instanciaBaseDeDados(){
        this.DBservice.instanciaBaseDeDados();
    }

}

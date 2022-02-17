package com.example.tateti.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaTeTiConfiguration {
    @Bean
    public Board getBoard(){
        return new Board();
    }
}

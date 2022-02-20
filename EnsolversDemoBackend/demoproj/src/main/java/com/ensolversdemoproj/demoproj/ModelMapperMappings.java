package com.ensolversdemoproj.demoproj;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperMappings {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

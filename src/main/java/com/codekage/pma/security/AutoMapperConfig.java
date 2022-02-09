package com.codekage.pma.security;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class AutoMapperConfig {

    @Bean
    public ModelMapper Mapper(){
        return new ModelMapper();
    }
}

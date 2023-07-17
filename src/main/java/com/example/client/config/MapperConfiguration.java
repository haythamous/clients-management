package com.example.client.config;

import com.example.client.mappers.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MapperConfiguration {
    @Bean
    public UserMapper userMapper() {
        return UserMapper.getInstance();
    }

}
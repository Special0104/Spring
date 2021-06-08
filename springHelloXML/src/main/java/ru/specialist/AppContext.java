package ru.specialist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
    @Bean
    public PersonBean person() {
        return new PersonBean("Sergey", 41);
    }
}

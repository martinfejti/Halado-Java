package web.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import calculator.Calculator;

@Configuration
public class Configurator {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }
}

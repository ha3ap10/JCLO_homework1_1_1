package ru.netology.jclo_homework1_1_1.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.jclo_homework1_1_1.profile.DevProfile;
import ru.netology.jclo_homework1_1_1.profile.ProductionProfile;
import ru.netology.jclo_homework1_1_1.profile.SystemProfile;

@Configuration
public class Config {

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}

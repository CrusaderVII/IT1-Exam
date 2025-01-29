package it1.exam.integration_spring_starter.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "bd-service")
@Getter
@Setter
public class ConfigProperties {

    private String host;
}

package it1.exam.integration_spring_starter.config;

import it1.exam.integration_spring_starter.service.AgreementRequestService;
import it1.exam.integration_spring_starter.service.impl.AgreementServiceRequestImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableConfigurationProperties(ConfigProperties.class)
@ConditionalOnClass(AgreementRequestService.class)
@RequiredArgsConstructor
public class StarterAutoConfig {

    private final ConfigProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public WebClient webClient() {
        WebClient webClient = WebClient.create(properties.getHost());
        return webClient;
    }

    @Bean
    @ConditionalOnMissingBean
    public AgreementRequestService agreementRequestService() {
        return new AgreementServiceRequestImpl(webClient());
    }
}

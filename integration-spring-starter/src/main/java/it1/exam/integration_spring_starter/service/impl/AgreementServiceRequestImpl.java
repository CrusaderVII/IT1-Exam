package it1.exam.integration_spring_starter.service.impl;

import it1.exam.integration_spring_starter.service.AgreementRequestService;
import it1.exam.mentoring.model.Agreement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

import static it1.exam.integration_spring_starter.service.impl.RequestHelper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AgreementServiceRequestImpl implements AgreementRequestService {

    private final WebClient webClient;

    @Override
    public Agreement getForAgreementById(UUID id) {
        log.info("[STARTER]:[GET_AGR_ID] sending request to bd-service. id={}", id);
        return webClient.get()
                .uri(GET_AGREEMENT_BY_ID_REQUEST.getValue(), id)
                .retrieve()
                .bodyToMono(Agreement.class)
                .block();
    }

    @Override
    public Agreement postForAgreement(Agreement newAgreement) {
        log.info("[STARTER]:[POST_AGR] sending request to bd-service");
        return webClient.post()
                .uri(POST_AGREEMENT.getValue())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(newAgreement)
                .retrieve()
                .bodyToMono(Agreement.class)
                .block();
    }

    @Override
    public void deleteForAgreementById(UUID id) {
        log.info("[STARTER]:[DELETE_AGR_ID] sending request to bd-service. id={}", id);
        webClient.delete()
                .uri(DELETE_AGREEMENT_BY_ID.getValue(), id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();

    }
}

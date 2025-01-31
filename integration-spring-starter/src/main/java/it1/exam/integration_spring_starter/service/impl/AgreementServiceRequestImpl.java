package it1.exam.integration_spring_starter.service.impl;

import it1.exam.integration_spring_starter.service.AgreementRequestService;
import it1.exam.mentoring.dto.AgreementDto;
import it1.exam.mentoring.model.Agreement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static it1.exam.integration_spring_starter.service.impl.RequestHelper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AgreementServiceRequestImpl implements AgreementRequestService {

    private final WebClient webClient;

    @Override
    public List<Agreement> getForAllAgreements() {
        log.info("[STARTER]:[AGREEMENT_SERVICE]:[GET_ALL] - sending request");

        List<Agreement> agreements = new ArrayList<>();
        agreements = webClient.get()
                .uri(GET_ALL_AGREEMENTS_REQUEST.getValue())
                .retrieve()
                .bodyToMono(agreements.getClass())
                .block();

        log.info("[STARTER]:[AGREEMENT_SERVICE]:[GET_ALL] - got {} results", agreements.size());
        return agreements;
    }

    @Override
    public Agreement getForAgreementById(UUID id) {
        log.info("[STARTER]:[AGREEMENT_SERVICE]:[GET_BY_ID] - sending request");

        Agreement Agreement = webClient.get()
                .uri(GET_AGREEMENT_BY_ID_REQUEST.getValue(), id)
                .retrieve()
                .bodyToMono(Agreement.class)
                .block();

        log.info("[STARTER]:[AGREEMENT_SERVICE]:[GET_BY_ID] - got 1 result: {}", Agreement);

        return Agreement;
    }

    @Override
    public Agreement postForAgreement(AgreementDto newAgreement) {
        log.info("[STARTER]:[AGREEMENT_SERVICE]:[POST_Agreement] - sending request");

        Agreement Agreement = webClient.post()
                .uri(POST_AGREEMENT_REQUEST.getValue())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(newAgreement)
                .retrieve()
                .bodyToMono(Agreement.class)
                .block();

        log.info("[STARTER]:[AGREEMENT_SERVICE]:[POST_Agreement] - saved new Agreement: {}", Agreement);

        return Agreement;
    }

    @Override
    public void deleteForAgreementById(UUID id) {
        log.info("[STARTER]:[AGREEMENT_SERVICE]:[DELETE_Agreement] - sending request");

        webClient.delete()
                .uri(DELETE_AGREEMENT_REQUEST.getValue(), id)
                .retrieve();
    }
}

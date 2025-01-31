package it1.exam.integration_spring_starter.service;

import it1.exam.mentoring.dto.AgreementDto;
import it1.exam.mentoring.model.Agreement;

import java.util.List;
import java.util.UUID;

public interface AgreementRequestService {

    List<Agreement> getForAllAgreements();
    Agreement getForAgreementById(UUID id);
    Agreement postForAgreement(AgreementDto newAgreement);
    void deleteForAgreementById(UUID id);
}

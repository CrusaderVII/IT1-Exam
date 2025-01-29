package it1.exam.integration_spring_starter.service;

import it1.exam.mentoring.model.Agreement;

import java.util.UUID;

public interface AgreementRequestService {

    Agreement getForAgreementById(UUID id);
    Agreement postForAgreement(Agreement newAgreement);
    void deleteForAgreementById(UUID id);
}

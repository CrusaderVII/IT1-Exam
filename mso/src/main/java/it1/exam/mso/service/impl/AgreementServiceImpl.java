package it1.exam.mso.service.impl;

import it1.exam.integration_spring_starter.service.AgreementRequestService;
import it1.exam.mentoring.model.Agreement;
import it1.exam.mentoring.model.Document;
import it1.exam.mso.service.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRequestService agreementRequestService;

    @Override
    public Agreement getAgreementById(UUID id) {
        return agreementRequestService.getForAgreementById(id);
    }

    @Override
    public Agreement saveNewAgreement(Agreement newAgreement) {
        return agreementRequestService.postForAgreement(newAgreement);
    }
}

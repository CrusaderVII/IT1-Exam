package it1.exam.mso.service;

import it1.exam.mentoring.dto.AgreementDto;
import it1.exam.mentoring.model.Agreement;

import java.util.List;
import java.util.UUID;

public interface AgreementService {

    List<Agreement> getAllAgreements();
    Agreement getAgreementById(UUID id);
    Agreement saveAgreement(AgreementDto newAgreement);
    void deleteAgreementById(UUID id);
}

package it1.exam.mso.service;

import it1.exam.mentoring.model.Agreement;
import it1.exam.mentoring.model.Document;

import java.util.List;
import java.util.UUID;

public interface AgreementService {

    Agreement getAgreementById(UUID id);
    Agreement saveNewAgreement(Agreement newAgreement);
}

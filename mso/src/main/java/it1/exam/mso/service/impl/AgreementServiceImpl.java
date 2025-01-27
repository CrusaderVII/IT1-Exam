package it1.exam.mso.service.impl;

import it1.exam.mentoring.model.Agreement;
import it1.exam.mentoring.model.Document;
import it1.exam.mso.service.AgreementService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AgreementServiceImpl implements AgreementService {

    @Override
    public Agreement getAgreementById(UUID id) {
        //TODO: integration with db service in starter
        return null;
    }

    @Override
    public Agreement saveNewAgreement(Agreement newAgreement) {
        //TODO: integration with db service in starter
        return null;
    }
}

package it1.exam.mso.service.impl;

import it1.exam.integration_spring_starter.service.AgreementRequestService;
import it1.exam.mentoring.dto.AgreementDto;
import it1.exam.mentoring.model.Agreement;
import it1.exam.mso.config.KafkaSender;
import it1.exam.mso.service.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRequestService agreementRequestService;
    private final KafkaSender kafkaSender;

    @Override
    public List<Agreement> getAllAgreements() {
        kafkaSender.send("get all agreements");
        return agreementRequestService.getForAllAgreements();
    }

    @Override
    public Agreement getAgreementById(UUID id) {
        kafkaSender.send("get agreement by id");
        return agreementRequestService.getForAgreementById(id);
    }

    @Override
    public Agreement saveAgreement(AgreementDto newAgreement) {
        return agreementRequestService.postForAgreement(newAgreement);
    }

    @Override
    public void deleteAgreementById(UUID id) {
        agreementRequestService.deleteForAgreementById(id);
    }
}

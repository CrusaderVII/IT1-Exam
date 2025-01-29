package it1.exam.mentoring.mapper;

import it1.exam.mentoring.config.EmptyCheck;
import it1.exam.mentoring.entity.AgreementEntity;
import it1.exam.mentoring.model.Agreement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AgreementMapper {

    public Agreement map(AgreementEntity agreementEntity) {
        return Agreement.builder()
                .id(agreementEntity.getAgreementId())
                .createDate(agreementEntity.getCreateDate())
                .name(agreementEntity.getName())
                .build();
    }

    @EmptyCheck
    public List<Agreement> map(List<AgreementEntity> agreementEntities) {
        return agreementEntities.stream().map(this::map).toList();
    }

    public AgreementEntity map(Agreement agreement) {
        return AgreementEntity.builder()
                .name(agreement.getName())
                .createDate(agreement.getCreateDate())
                .build();
    }
}

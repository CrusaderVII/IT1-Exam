package it1.exam.mentoring.service;

import it1.exam.mentoring.entity.AgreementEntity;
import it1.exam.mentoring.mapper.AgreementMapper;
import it1.exam.mentoring.model.Agreement;
import it1.exam.mentoring.repository.AgreementRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class AgreementServiceTest {
    @Mock
    AgreementRepository agreementRepository;

    @Spy
    AgreementMapper agreementMapper = new AgreementMapper();

    @InjectMocks
    AgreementService agreementService;

    @Test
    void shouldFindAgreementById() {
        UUID id = UUID.randomUUID();

        Mockito.when(agreementRepository.findById(id)).thenReturn(Optional.of(AgreementEntity.builder()
                .agreementId(id)
                .name("Name")
                .createDate(LocalDate.of(2024, 4, 4))
                .build()));

        Agreement agreement = agreementService.getAgreement(id);
        Agreement expected = Agreement.builder()
                .id(id)
                .name("Name")
                .createDate(LocalDate.of(2024, 4, 4))
                .build();

        Assertions.assertThat(agreement).isEqualTo(expected);
    }

}
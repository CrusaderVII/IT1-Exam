package it1.exam.mentoring.service;

import it1.exam.mentoring.entity.AgreementEntity;
import it1.exam.mentoring.exception.NotFoundException;
import it1.exam.mentoring.mapper.AgreementMapper;
import it1.exam.mentoring.model.Agreement;
import it1.exam.mentoring.repository.AgreementRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AgreementService {
    private final AgreementRepository agreementRepository;
    private final AgreementMapper agreementMapper;

    public Agreement getAgreement(UUID id) {
        AgreementEntity entity = agreementRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cannot find agreement with id: " + id));
        return agreementMapper.map(entity);
    }

    public List<Agreement> getAgreements() {
        return agreementMapper.map(agreementRepository.findAll());
    }

    @Transactional
    public void save(Agreement agreement) {
        log.info("Creating new agreement: {}", agreement);
        agreementRepository.save(agreementMapper.map(agreement));
    }

    @Transactional
    public void deleteById(UUID id) {
        log.info("Deleting agreement by id: {}", id);
        agreementRepository.deleteById(id);
    }
}

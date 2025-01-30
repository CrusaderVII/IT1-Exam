package it1.exam.mentoring.repository;

import it1.exam.mentoring.entity.AgreementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgreementRepository extends JpaRepository<AgreementEntity, UUID> {
}

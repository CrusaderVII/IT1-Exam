package it1.exam.mso.controller;

import it1.exam.mentoring.dto.AgreementDto;
import it1.exam.mentoring.model.Agreement;
import it1.exam.mso.service.AgreementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exam/agreement")
@Slf4j
public class AgreementController {

    private final AgreementService agreementService;

    @GetMapping
    public List<Agreement> getAllAgreements() {
        return agreementService.getAllAgreements();
    }

    @GetMapping("/{id}")
    public Agreement getAgreement(@PathVariable UUID id) {
        return agreementService.getAgreementById(id);
    }

    @PostMapping()
    public Agreement saveAgreement(@RequestBody AgreementDto newAgreement) {
        return agreementService.saveAgreement(newAgreement);
    }

    @DeleteMapping("/{id}")
    public void deleteAgreementById(@PathVariable UUID id) {
        agreementService.deleteAgreementById(id);
    }
}

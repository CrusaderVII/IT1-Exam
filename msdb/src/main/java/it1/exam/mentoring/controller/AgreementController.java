package it1.exam.mentoring.controller;

import it1.exam.mentoring.model.Agreement;
import it1.exam.mentoring.service.AgreementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/agreement")
@RequiredArgsConstructor
public class AgreementController {
    private final AgreementService agreementService;

    @GetMapping("/{id}")
    public Agreement getAgreement(@PathVariable("id") UUID id) {
        return agreementService.getAgreement(id);
    }

    @GetMapping
    public List<Agreement> getAgreements() {
        return agreementService.getAgreements();
    }

    @PostMapping
    public void save(@RequestBody Agreement agreement) {
        agreementService.save(agreement);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        agreementService.deleteById(id);
    }

}

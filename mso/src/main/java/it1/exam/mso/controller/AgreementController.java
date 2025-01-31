package it1.exam.mso.controller;

import it1.exam.mentoring.dto.AgreementDto;
import it1.exam.mentoring.model.Agreement;
import it1.exam.mso.service.AgreementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exam/agreement")
@Slf4j
public class AgreementController {

    private final AgreementService service;

    @GetMapping("/agreement/{id}")
    public Agreement getAgreement(@PathVariable UUID id) {
        log.info("[INFO]:[MAIN-CONTROLLER]: in get by id method");
        return service.getAgreementById(id);
    }

    @PostMapping("/agreement")
    public Agreement saveAgreement(@RequestBody AgreementDto newAgreement) {
        log.info("[INFO]:[MAIN-CONTROLLER]: in save method");
        return service.saveAgreement(newAgreement);
    }
}

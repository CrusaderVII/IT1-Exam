package it1.exam.mso.controller;

import it1.exam.mentoring.model.Agreement;
import it1.exam.mso.service.AgreementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exam")
@Slf4j
public class MainController {

    private final AgreementService service;

    @GetMapping("/agreement/get")
    public Agreement getAgreement(@PathVariable UUID id) {
        log.info("[INFO]:[MAIN-CONTROLLER]: in get by id method");
        return service.getAgreementById(id);
    }

    @PostMapping("/agreement/save")
    public Agreement saveAgreement(@RequestBody Agreement newAgreement) {
        log.info("[INFO]:[MAIN-CONTROLLER]: in save method");
        return service.saveNewAgreement(newAgreement);
    }
}

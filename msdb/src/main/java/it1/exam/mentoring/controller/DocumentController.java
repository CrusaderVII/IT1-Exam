package it1.exam.mentoring.controller;

import it1.exam.mentoring.model.Document;
import it1.exam.mentoring.service.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/document")
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService documentService;

    @GetMapping("/{id}")
    public Document getDocument(@PathVariable("id") UUID id) {
        return documentService.getDocument(id);
    }

    @GetMapping
    public List<Document> getDocuments() {
        return documentService.getDocuments();
    }

    @PostMapping
    public void save(@RequestBody Document document) {
        documentService.save(document);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        documentService.deleteById(id);
    }
}

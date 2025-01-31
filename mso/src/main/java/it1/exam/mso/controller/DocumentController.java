package it1.exam.mso.controller;

import it1.exam.mentoring.dto.DocumentDto;
import it1.exam.mentoring.model.Document;
import it1.exam.mso.service.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exam/document")
@Slf4j
public class DocumentController {

    private final DocumentService documentService;

    @GetMapping()
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/{id}")
    public Document getDocumentById(@PathVariable UUID id) {
        return documentService.getDocumentById(id);
    }

    @PostMapping()
    public Document saveDocument(DocumentDto newDocument) {
        return documentService.saveDocument(newDocument);
    }

    @DeleteMapping("/{id}")
    public void deleteDocumentById(UUID id) {
        documentService.deleteDocumentById(id);
    }
}

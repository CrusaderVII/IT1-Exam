package it1.exam.integration_spring_starter.service;

import it1.exam.mentoring.dto.DocumentDto;
import it1.exam.mentoring.model.Document;

import java.util.List;
import java.util.UUID;

public interface DocumentRequestService {
    List<Document> getForAllDocuments();
    Document getForDocumentById(UUID id);
    Document postForDocument(DocumentDto newDocument);
    void deleteForDocumentById(UUID id);
}

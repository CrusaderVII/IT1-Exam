package it1.exam.mso.service;

import it1.exam.mentoring.dto.DocumentDto;
import it1.exam.mentoring.model.Document;

import java.util.List;
import java.util.UUID;

public interface DocumentService {

    List<Document> getAllDocuments();
    Document getDocumentById(UUID id);
    Document saveDocument(DocumentDto newDocument);
    void deleteDocumentById(UUID id);
}

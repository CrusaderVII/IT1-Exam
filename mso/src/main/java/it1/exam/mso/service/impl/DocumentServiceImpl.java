package it1.exam.mso.service.impl;

import it1.exam.integration_spring_starter.service.DocumentRequestService;
import it1.exam.mentoring.dto.DocumentDto;
import it1.exam.mentoring.model.Document;
import it1.exam.mso.config.KafkaSender;
import it1.exam.mso.service.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRequestService documentRequestService;
    private final KafkaSender kafkaSender;

    @Override
    public List<Document> getAllDocuments() {
        CompletableFuture<Void> sendKafkaMessage = CompletableFuture.runAsync(() -> kafkaSender.send("get all documents"));
        return documentRequestService.getForAllDocuments();
    }

    @Override
    public Document getDocumentById(UUID id) {
        CompletableFuture<Void> sendKafkaMessage = CompletableFuture.runAsync(() -> kafkaSender.send("get document by id"));
        return documentRequestService.getForDocumentById(id);
    }

    @Override
    public Document saveDocument(DocumentDto newDocument) {
        return documentRequestService.postForDocument(newDocument);
    }

    @Override
    public void deleteDocumentById(UUID id) {
        documentRequestService.deleteForDocumentById(id);
    }
}

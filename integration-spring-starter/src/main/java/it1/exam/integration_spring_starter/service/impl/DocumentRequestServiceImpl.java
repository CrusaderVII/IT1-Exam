package it1.exam.integration_spring_starter.service.impl;

import it1.exam.integration_spring_starter.service.DocumentRequestService;
import it1.exam.mentoring.dto.DocumentDto;
import it1.exam.mentoring.model.Document;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static it1.exam.integration_spring_starter.service.impl.RequestHelper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentRequestServiceImpl implements DocumentRequestService {

    private final WebClient webClient;

    @Override
    public List<Document> getForAllDocuments() {
        log.info("[STARTER]:[DOCUMENT_SERVICE]:[GET_ALL] - sending request");

        List<Document> documents = new ArrayList<>();
        documents = webClient.get()
                .uri(GET_ALL_DOCUMENTS_REQUEST.getValue())
                .retrieve()
                .bodyToMono(documents.getClass())
                .block();

        log.info("[STARTER]:[DOCUMENT_SERVICE]:[GET_ALL] - got {} results", documents.size());
        return documents;
    }

    @Override
    public Document getForDocumentById(UUID id) {
        log.info("[STARTER]:[DOCUMENT_SERVICE]:[GET_BY_ID] - sending request");

        Document document = webClient.get()
                .uri(GET_DOCUMENT_BY_ID_REQUEST.getValue(), id)
                .retrieve()
                .bodyToMono(Document.class)
                .block();

        log.info("[STARTER]:[DOCUMENT_SERVICE]:[GET_BY_ID] - got 1 result: {}", document);

        return document;
    }

    @Override
    public Document postForDocument(DocumentDto newDocument) {
        log.info("[STARTER]:[DOCUMENT_SERVICE]:[POST_DOCUMENT] - sending request");

        Document document = webClient.post()
                .uri(POST_DOCUMENT_REQUEST.getValue())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(newDocument)
                .retrieve()
                .bodyToMono(Document.class)
                .block();

        log.info("[STARTER]:[DOCUMENT_SERVICE]:[POST_DOCUMENT] - saved new document: {}", document);

        return document;
    }

    @Override
    public void deleteForDocumentById(UUID id) {
        log.info("[STARTER]:[DOCUMENT_SERVICE]:[DELETE_DOCUMENT] - sending request");

        webClient.delete()
                .uri(DELETE_DOCUMENT_REQUEST.getValue(), id)
                .retrieve();
    }
}

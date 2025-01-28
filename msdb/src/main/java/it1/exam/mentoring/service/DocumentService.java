package it1.exam.mentoring.service;

import it1.exam.mentoring.entity.DocumentEntity;
import it1.exam.mentoring.exception.NotFoundException;
import it1.exam.mentoring.mapper.DocumentMapper;
import it1.exam.mentoring.model.Document;
import it1.exam.mentoring.repository.DocumentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    public Document getDocument(UUID id) {
        DocumentEntity documentEntity = documentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cannot find document by id: " + id));
        return documentMapper.map(documentEntity);
    }

    public List<Document> getDocuments() {
        return documentMapper.map(documentRepository.findAll());
    }

    @Transactional
    public void save(Document document) {
        log.info("Creating new document: {}", document);
        documentRepository.save(documentMapper.map(document));
    }

    @Transactional
    public void deleteById(UUID id) {
        log.info("Deleting document by id: {}", id);
        documentRepository.deleteById(id);
    }
}

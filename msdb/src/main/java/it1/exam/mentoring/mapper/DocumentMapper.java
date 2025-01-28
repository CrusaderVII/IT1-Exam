package it1.exam.mentoring.mapper;

import it1.exam.mentoring.config.EmptyCheck;
import it1.exam.mentoring.entity.DocumentEntity;
import it1.exam.mentoring.model.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentMapper {

    public Document map(DocumentEntity documentEntity) {
        return Document.builder()
                .id(documentEntity.getDocumentId())
                .name(documentEntity.getName())
                .number(documentEntity.getNumber())
                .signDate(documentEntity.getSignDate())
                .createDate(documentEntity.getCreateDate())
                .agreementId(documentEntity.getAgreement().getAgreementId())
                .build();
    }

    @EmptyCheck
    public List<Document> map(List<DocumentEntity> documentEntities) {
        return documentEntities.stream().map(this::map).toList();
    }

    public DocumentEntity map(Document document) {
        return DocumentEntity.builder()
                .signDate(document.getSignDate())
                .number(document.getNumber())
                .createDate(document.getCreateDate())
                .name(document.getName())
                .build();
    }

}

package it1.exam.integration_spring_starter.service.impl;

public enum RequestHelper {
    //Agreement
    GET_ALL_AGREEMENTS_REQUEST("/agreement"),
    GET_AGREEMENT_BY_ID_REQUEST("/agreement/{id}"),
    POST_AGREEMENT_REQUEST("/agreement"),
    DELETE_AGREEMENT_REQUEST("/agreement/{id}"),

    //Document
    GET_ALL_DOCUMENTS_REQUEST("/document"),
    GET_DOCUMENT_BY_ID_REQUEST("/document/{id}"),
    POST_DOCUMENT_REQUEST("/document"),
    DELETE_DOCUMENT_REQUEST("/document");

    private final String value;

    RequestHelper(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

}

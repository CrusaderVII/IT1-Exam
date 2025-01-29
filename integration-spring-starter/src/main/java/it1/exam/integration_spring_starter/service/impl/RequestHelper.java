package it1.exam.integration_spring_starter.service.impl;

public enum RequestHelper {
    GET_AGREEMENT_BY_ID_REQUEST("/agreement/{id}"),
    POST_AGREEMENT("/agreement"),
    DELETE_AGREEMENT_BY_ID("/agreement/{id}");

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

package com.charsharing.bootcamp.admin.service;

import com.charsharing.bootcamp.admin.domain.Document;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@Slf4j
public class DocumentListService {
    @Value("${charSharing.document.service.url}")
    String documentServiceURL;
    private RestTemplateBuilder builder;

    public DocumentListService(RestTemplateBuilder builder) {

        this.builder = builder;
    }

    public List<Document> getDocumentList() {
        final Document[] documentArray = builder.build().getForEntity(documentServiceURL + "documents", Document[].class).getBody();
        return isNull(documentArray) ? Collections.emptyList() : Arrays.asList(documentArray);
    }

    public ResponseEntity<Void> deleteDocument(List<String> documents) {
        log.info("Calling {} to delete Documents", documentServiceURL + "documents");
        final ResponseEntity<Void> response = builder.build().exchange(documentServiceURL + "documents", HttpMethod.DELETE, new HttpEntity<>(documents), Void.class);
        return ResponseEntity.status(response.getStatusCode()).build();
    }
}

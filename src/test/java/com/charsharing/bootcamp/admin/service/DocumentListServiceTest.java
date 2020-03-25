package com.charsharing.bootcamp.admin.service;

import com.charsharing.bootcamp.admin.domain.Document;
import org.hamcrest.Matchers;
import org.mockito.Mock;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class DocumentListServiceTest {

    DocumentListService service;

    @Mock
    RestTemplateBuilder builder;

    @Mock
    RestTemplate template;

    @BeforeMethod
    public void init() {
        initMocks(this);
        service = new DocumentListService(builder);
        when(builder.build()).thenReturn(template);
    }

    @Test
    public void shouldGetListOfDocuments() {
        Document document = new Document();
        document.setTitle("example");
        Document[] documents = {document};
        when(template.getForEntity(anyString(), any()))
                .thenReturn(ResponseEntity.ok(documents));
        final List<Document> actual = service.getDocumentList();
        assertThat(actual, Matchers.is(List.of(document)));

    }

    @Test
    public void shouldGetEmptyListOfDocuments() {
        when(template.getForEntity(anyString(), any()))
                .thenReturn(ResponseEntity.ok(new Document[0]));
        final List<Document> actual = service.getDocumentList();
        assertThat(actual, Matchers.is(List.of()));
    }
}
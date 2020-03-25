package com.charsharing.bootcamp.admin.controller;

import com.charsharing.bootcamp.admin.service.DocumentListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DocumentController {

    @Autowired
    private DocumentListService documentListService;

    /**
     * Deletes a list of documents
     * @param documents a list of the titles of the documents which shall be deleted
     * @return a http response without a body
     */
    @DeleteMapping("/")
    public ResponseEntity<Void> deleteDocument(@RequestBody List<String> documents) {
        log.info("Delete Request received");
        return documentListService.deleteDocument(documents);
    }

}

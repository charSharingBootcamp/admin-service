package com.charsharing.bootcamp.admin.controller;

import com.charsharing.bootcamp.admin.domain.Document;
import com.charsharing.bootcamp.admin.service.DocumentListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class DocumentListController {

    @Value("${charSharing.page.home.url}")
    private String homeURL;

    @Autowired
    private DocumentListService documentListService;

    /**
     * returns the Admin HTML page
     * @param model a Model which is used to transfer data to the HTML
     * @return The Name of the HTML file
     */
    @GetMapping("/")
    public String getDocumentListPage(Model model) {

        final List<Document> documentList = documentListService.getDocumentList();
        model.addAttribute("documentList", documentList);
        model.addAttribute("homeURL", homeURL);
        return "index";
    }
}

package com.charsharing.bootcamp.admin.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Document {

    private String title;

    private String creator;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createdAt;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date updatedAt;

    private boolean isArchived;
}

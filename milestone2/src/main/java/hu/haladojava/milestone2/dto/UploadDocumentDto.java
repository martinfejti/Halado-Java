package hu.haladojava.milestone2.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadDocumentDto {

    private int userId;
    private MultipartFile document;
    
    public UploadDocumentDto() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public MultipartFile getDocument() {
        return document;
    }

    public void setDocument(MultipartFile document) {
        this.document = document;
    }
}

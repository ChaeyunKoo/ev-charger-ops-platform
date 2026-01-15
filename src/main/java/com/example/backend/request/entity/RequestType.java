package com.example.backend.request.entity;

public enum RequestType {

    COMPLAINT("민원"),
    REPAIR("수리요청"),
    INQUIRY("문의"),
    SUGGESTION("건의사항"),
    OTHER("기타");

    private final String description;

    RequestType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

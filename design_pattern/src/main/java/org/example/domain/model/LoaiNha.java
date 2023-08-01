package org.example.domain.model;

public enum LoaiNha {
    CAO_CAP("Cao cấp"),
    THUONG("Thường");

    private String value;

    LoaiNha(String value) {
        this.value = value;
    }
}

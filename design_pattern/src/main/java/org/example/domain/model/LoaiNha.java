package org.example.domain.model;

public enum LoaiNha {
    CAO_CAP("Cao cap"),
    THUONG("Thuong");

    private String value;

    LoaiNha(String value) {
        this.value = value;
    }

    public static LoaiNha fromString(String value) {
        for (LoaiNha loaiNha : LoaiNha.values()) {
            if (loaiNha.value.equalsIgnoreCase(value)) {
                return loaiNha;
            }
        }
        throw new IllegalArgumentException("Invalid LoaiNha value: " + value);
    }
}

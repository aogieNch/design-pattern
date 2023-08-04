package org.example.domain.model;

public enum LoaiDat {
    A("A"),
    B("B"),
    C("C");

    private String value;

    LoaiDat(String value) {
        this.value = value;
    }

    public static LoaiDat fromString(String value) {
        for (LoaiDat loaiDat : LoaiDat.values()) {
            if (loaiDat.value.equalsIgnoreCase(value)) {
                return loaiDat;
            }
        }
        throw new IllegalArgumentException("Invalid LoaiDat value: " + value);
    }
}

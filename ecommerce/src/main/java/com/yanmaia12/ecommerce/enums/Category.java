package com.yanmaia12.ecommerce.enums;

public enum Category {

    ELECTRONICS("Eletronico"),
    CLOTHING("Roupas"),
    FOOD("Comida"),
    BOOKS("Livros"),
    SPORTS("Esporte"),
    HOME("Casa"),
    BEAUTY("Beleza"),
    TOYS("Brinquedo");

    private final String label;

    Category(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

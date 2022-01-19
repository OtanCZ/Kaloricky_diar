package com.src.kaloricky_diar;

public enum TimeOfDay {
    Morning("Ráno"),
    Forenoon("Dopoledne"),
    Noon("Poledne"),
    Afternoon("Odpoledne"),
    Evening("Večer");

    private final String name;

    TimeOfDay(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

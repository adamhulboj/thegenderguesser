package com.example.genderguesser.GenderTokens;

import java.util.HashMap;
import java.util.Map;

public enum TokenType {
    MALE ("male", "m"),
    FEMALE ("female", "f"),
    INCONLUSIVE ("", "");

    private static final Map<String, TokenType> BY_GENDER = new HashMap<>();
    private static final Map<String, TokenType> BY_SHORTCUT = new HashMap<>();

    static {
        for (TokenType e : values()) {
            BY_GENDER.put(e.gender, e);
            BY_SHORTCUT.put(e.shortCut, e);
        }
    }

    public final String gender;
    public final String shortCut;

    private TokenType(String gender, String shortCut) {
        this.gender = gender.toLowerCase();
        this.shortCut = shortCut.toLowerCase();
    }

    private TokenType(String gender) {
        this.gender = gender.toLowerCase();
        this.shortCut = String.valueOf(gender.toLowerCase().charAt(0));
    }
}



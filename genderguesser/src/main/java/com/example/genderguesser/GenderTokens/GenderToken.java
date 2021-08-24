package com.example.genderguesser.GenderTokens;

public class GenderToken {
    private Long id;
    private String gToken;
    private TokenType gender;

    public GenderToken(Long id, String gToken, TokenType gender) {
        this.id = id;
        this.gToken = gToken;
        this.gender = gender;
    }

    public GenderToken(String gToken, TokenType gender) {
        this.gToken = gToken;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getgToken() {
        return gToken;
    }

    public TokenType getGender() {
        return gender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setgToken(String gToken) {
        this.gToken = gToken;
    }

    public void setGender(TokenType gender) {
        this.gender = gender;
    }

    public void setGender(String gender) {
        if (gender.equals("M")) {
            this.gender = TokenType.male;
        }
        if (gender.equals("F")) {
            this.gender = TokenType.female;
        }

    }

    @Override
    public String toString() {
        return "GenderToken{" +
                "id=" + id +
                ", gToken='" + gToken + '\'' +
                ", gender=" + gender +
                '}';
    }
}

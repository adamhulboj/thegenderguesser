package com.example.genderguesser.GenderTokens;

import javax.persistence.*;

@Entity
@Table (name = "GG.gender_tokens")
public class GenderToken {
    @Id
    @SequenceGenerator(
            name = "gendertokens_sq",
            sequenceName = "gendertokens_sq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "gendertokens_sq"
    )
    @Column( name = "ident")
    private Long id;
    @Column( name = "tokenname")
    private String gToken;
    @Column( name = "gender")
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
            this.gender = TokenType.MALE;
        }
        else if (gender.equals("F")) {
            this.gender = TokenType.FEMALE;
        }
        else {
            this.gender = TokenType.INCONLUSIVE;
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

package com.example.genderguesser.GenderTokens;

import javax.persistence.*;

@Entity
@Table (name = "gender_tokens", schema = "GG")
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
    private String gender;

    public GenderToken(){}

    public GenderToken(Long id, String gToken, String gender) {
        this.id = id;
        this.gToken = gToken;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }
    public String getgToken() {
        return gToken;
    }
    public String getGender() {
        return gender;
    }
    public void setId(Long id) { this.id = id; }
    public void setgToken(String gToken) { this.gToken = gToken; }
    public void setGender(String gender) { this.gender = gender; }


    public TokenType toTokenType() {
        if (gender.equals("M")) {
            return TokenType.MALE;
        }
        else if (gender.equals("F")) {
            return TokenType.FEMALE;
        }
        else {
            return TokenType.INCONLUSIVE;
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

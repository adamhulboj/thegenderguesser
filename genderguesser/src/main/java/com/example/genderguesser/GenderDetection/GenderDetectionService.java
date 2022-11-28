package com.example.genderguesser.GenderDetection;

import antlr.Token;
import com.example.genderguesser.TokenType;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class GenderDetectionService {

    public static final String first_token = "FIRST";
    public static final String all_tokens = "ALL";

    public String detectGender (String token, @NotNull String checkTokens){

        String[] words = token.split("\\W+");  //splitting words

        if (checkTokens.toUpperCase().equals(first_token))  return detectGenderFromToken(words[0]).gender;
        else if (checkTokens.toUpperCase().equals(all_tokens)) return detectGenderFromListOfTokens(words);
        return "";
    }

    public TokenType detectGenderFromToken(String token) {
        //return "male";
        //algorithm for detect gender having one token versionable (from file/form databse)

        SearchWordinFile searchFileMale = new SearchWordinFile(token,"male.txt");
        if (searchFileMale.search(1)) return TokenType.MALE;

        SearchWordinFile searchFileFemale = new SearchWordinFile(token,"female.txt");
        if (searchFileFemale.search(1)) return TokenType.FEMALE;

        return TokenType.INCONLUSIVE;
    }

    public String detectGenderFromListOfTokens(String[] tokens) {
        int males = 0;
        int females = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (detectGenderFromToken(tokens[i]) == TokenType.MALE) males++;
            if (detectGenderFromToken(tokens[i]) == TokenType.FEMALE) females++;
        }

        if (males>females) return TokenType.MALE.gender;
        else if (males<females) return TokenType.FEMALE.gender;
        else return TokenType.INCONLUSIVE.gender;
    }

}

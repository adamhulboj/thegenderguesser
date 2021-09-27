package com.example.genderguesser.GenderDetection;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class GenderDetectionService {

    public static final String first_token = "FIRST";
    public static final String all_tokens = "ALL";

    public String detectGender (String token, @NotNull String checkTokens){

        if (checkTokens.toUpperCase().equals(first_token)) {
           return detectGenderFromToken(token);
        }
        else if (checkTokens.toUpperCase().equals(all_tokens))
        {
            String[] words = token.split("\\W+");  //splitting words
            return detectGenderFromListOfTokens(words);
        }
        else {
            return "";
        }
    }

    public String detectGenderFromToken(String token) {
        return "male";
    }

    public String detectGenderFromListOfTokens(String[] tokens) {
        String detected = "";
        for (int i = 0; i < tokens.length; i++) {
           detected = detected + detectGenderFromToken(tokens[i]);
        }
       // return "inconclusive";
        return detected;
    }

}

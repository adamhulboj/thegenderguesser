package com.example.genderguesser.GenderDetection;

import com.example.genderguesser.GenderTokens.GenderToken;
import com.example.genderguesser.GenderTokens.GenderTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class GenderDetectionService {

    public static final String first_token = "FIRST";
    public static final String all_tokens = "ALL";

    public String detectGender (String token, String checkTokens){


        if (checkTokens.toUpperCase() == first_token) {
           return detectGenderFromToken(token);
        }

        else if (checkTokens.toUpperCase() == all_tokens)
        {
            //String s = "This is a sample sentence with []s.";
            String[] words = token.split("\\W+");
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
        String detected;
        for (int i = 0; i < tokens.length -1; i++) {
           detected = detectGenderFromToken(tokens[i]);
        }
        return "inconclusive";
    }

}

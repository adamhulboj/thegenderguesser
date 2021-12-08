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
        //return "male";
        //algorithm for detect gender having one token versionable (from file/form databse)

        SearchWordinFile searchFileMale = new SearchWordinFile(token,"male_katowice.txt");
        if (searchFileMale.search())  return "male";

        SearchWordinFile searchFileFemale = new SearchWordinFile(token,"female_katowice.txt");
        if (searchFileMale.search()) return "female";

        return "inconclusive";
    }

    public String detectGenderFromListOfTokens(String[] tokens) {
        String detected = "";
        for (int i = 0; i < tokens.length; i++) {
           detected = detected + detectGenderFromToken(tokens[i]);
        }
        return detected;
    }

}

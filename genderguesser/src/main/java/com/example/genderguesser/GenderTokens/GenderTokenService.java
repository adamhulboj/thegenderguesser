package com.example.genderguesser.GenderTokens;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderTokenService {

    public List<GenderToken>  getGenderTokens_static (String genderType){

        if (genderType.equals("male")) {

            return List.of(
                    new GenderToken(
                            1L,
                            "Adam",
                            TokenType.MALE)
            );
        } else if (genderType.equals("female")) {
            return List.of(
                    new GenderToken(
                            2L,
                            "Anna",
                            TokenType.FEMALE)
            );
        } else {
            return List.of(
                    new GenderToken(
                            3L,
                            "Someone",
                            TokenType.INCONLUSIVE)
            );
        }
    }

}

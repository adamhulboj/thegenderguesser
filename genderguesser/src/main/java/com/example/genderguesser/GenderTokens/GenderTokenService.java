package com.example.genderguesser.GenderTokens;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class GenderTokenService {

    private final GenderTokenRepository genderTokenRepository;

    @Autowired
    public GenderTokenService(GenderTokenRepository genderTokenRepository) {
        this.genderTokenRepository = genderTokenRepository;
    }

    public List<GenderToken>  getGenderTokens_static (String genderType){

        if (genderType.equals("male")) {

            return List.of(
                    new GenderToken(
                            1L,
                            "Adam",
                            "M")
            );
        } else if (genderType.equals("female")) {
            return List.of(
                    new GenderToken(
                            2L,
                            "Anna",
                            "F")
            );
        } else {
            return List.of(
                    new GenderToken(
                            3L,
                            "Someone",
                            "")
            );
        }
    }

    public List<GenderToken>  getGenderTokens_fromDatabase(String genderType){
        return genderTokenRepository.findAll();
    }

    public List<String> getGenderToken_fromDBbyToken(String token){
        return genderTokenRepository.findGenderByGivenToken(token.toUpperCase());
    }

}

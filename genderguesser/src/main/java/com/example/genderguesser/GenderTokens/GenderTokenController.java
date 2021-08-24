package com.example.genderguesser.GenderTokens;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/gendertokens")
public class GenderTokenController {

    @GetMapping
    public List<GenderToken> getGenderTokens(@RequestParam(value = "gendertype", defaultValue = "male") String gendertype) {

        if (gendertype.equals("male")) {

            return List.of(
                    new GenderToken(
                            1L,
                            "Adam",
                            TokenType.MALE)
            );
        } else if (gendertype.equals("female")) {
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

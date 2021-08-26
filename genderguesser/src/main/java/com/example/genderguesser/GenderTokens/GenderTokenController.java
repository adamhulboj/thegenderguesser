package com.example.genderguesser.GenderTokens;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/gendertokens")
public class GenderTokenController {

    private final GenderTokenService genderTokenService;

    public GenderTokenController(GenderTokenService genderTokenService) {
        this.genderTokenService = genderTokenService;
    }

    @GetMapping
    public List<GenderToken> getGenderTokens(@RequestParam(value = "gendertype", defaultValue = "male") String genderType) {

        return genderTokenService.getGenderTokens(genderType);

    }
}

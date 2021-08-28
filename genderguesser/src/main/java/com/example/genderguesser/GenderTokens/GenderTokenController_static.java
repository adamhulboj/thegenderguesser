package com.example.genderguesser.GenderTokens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/gendertokens_static")
public class GenderTokenController_static {

    private final GenderTokenService genderTokenService;

    @Autowired
    public GenderTokenController_static(GenderTokenService genderTokenService) {
        this.genderTokenService = genderTokenService;
    }

    @GetMapping
    public List<GenderToken> getGenderTokens(@RequestParam(value = "gendertype", defaultValue = "male") String genderType) {
        return genderTokenService.getGenderTokens_static(genderType);
    }
}

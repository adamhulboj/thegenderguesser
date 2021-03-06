package com.example.genderguesser.GenderTokens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/gendertoken")
public class GenderTokenController {

    private final GenderTokenService genderTokenService;

    @Autowired
    public GenderTokenController(GenderTokenService genderTokenService) {
        this.genderTokenService = genderTokenService;
    }

    @GetMapping
    public List<String> getGenderToken(@RequestParam(value = "token", defaultValue = "") String token) {
        return genderTokenService.getGenderToken_fromDBbyToken(token);
    }
}

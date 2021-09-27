package com.example.genderguesser.GenderDetection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/genderdetection")
public class GenderDetectionController {

    private final GenderDetectionService genderDetectionService;
    @Autowired
    public GenderDetectionController(GenderDetectionService genderDetectionService) {
        this.genderDetectionService = genderDetectionService;
    }

    @GetMapping
    public String detectGender(@RequestParam(name = "token", defaultValue = "") String token,
                @RequestParam (name ="checktokens", defaultValue = "first") String checkTokens) {
        return genderDetectionService.detectGender(token, checkTokens);
      //  return "bla bla bla "+token+" "+checkTokens;
    }

}
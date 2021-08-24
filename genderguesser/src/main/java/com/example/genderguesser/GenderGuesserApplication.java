package com.example.genderguesser;

import com.example.genderguesser.GenderTokens.GenderToken;
import com.example.genderguesser.GenderTokens.TokenType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class GenderGuesserApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenderGuesserApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("hello2")
	public String hello2() {
		return "czesc";
	}

	@GetMapping("/error")
	public String err() {
		return "somfin went wong";
	}

	@GetMapping("/gendertokens")
	public List<GenderToken> gendertokens(@RequestParam(value = "gendertype", defaultValue = "male") String gendertype){




		return List.of(
				new GenderToken(
						1L,
						"Adam",
						TokenType.MALE)
		);
	}


}

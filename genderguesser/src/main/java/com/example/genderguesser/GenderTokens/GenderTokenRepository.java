package com.example.genderguesser.GenderTokens;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenderTokenRepository extends JpaRepository<GenderToken,Long> {

    @Query("select g.gender FROM GenderToken g WHERE g.gToken =?1")
    List<String> findGenderByGivenToken(String token);
}




package com.example.genderguesser.GenderTokens;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderTokenRepository extends JpaRepository<GenderToken,Long> {
}

package com.microservices.character;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character,Integer> {
    List<Character> findByAnimeId(String animeId);
}

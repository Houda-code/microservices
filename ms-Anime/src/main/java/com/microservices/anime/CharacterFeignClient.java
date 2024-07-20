package com.microservices.anime;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "character-service")
public interface CharacterFeignClient {

    @GetMapping("/characters/anime/{animeId}")
    List<Character> getCharactersByAnimeId(@PathVariable("animeId") String animeId);
}
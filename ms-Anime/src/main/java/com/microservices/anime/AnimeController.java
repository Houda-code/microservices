package com.microservices.anime;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/anime")
public record   AnimeController(AnimeSrvice animeSrvice) {
//    @Autowired
//    private AnimeSrvice animeSrvice;
    @PostMapping
    public void saveAnime(@RequestBody AnimeRequest animeRequest){
        log.info("Saving character request");
        animeSrvice.saveAnime(animeRequest);
    }

    @GetMapping("/{id}")
    public Anime getAnimeById(@PathVariable String id) {
        log.info("Fetching character with id {}", id);
        return animeSrvice.getById(id);
    }
    @GetMapping
    public List<Anime> getAll() {
        return animeSrvice.getAll();
    }

    @GetMapping("/{animeId}/characters")
    public List<Character> getCharactersByAnimeId(@PathVariable String animeId) {
        return animeSrvice.getCharactersByAnimeId(animeId);
    }
}

package com.microservices.character;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/character")
public class characterController {
    @Autowired
    private CharacterRepository characterRepository;
    private CharacterService characterService;
    @PostMapping
    public void saveCharacter(@RequestBody CharacterRequest characterRequest){
        log.info("Saving character request");
        characterService.saveCharacter(characterRequest);
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable Integer id) {
        log.info("Fetching character with id {}", id);
        return characterService.getById(id);
    }

    @GetMapping
    public List<Character> getAllCharacters() {
        log.info("Fetching all characters");
        return characterService.getAll();
    }

    @GetMapping("/anime/{animeId}")
    public List<Character> getCharactersByAnimeId(@PathVariable String animeId) {
        return characterRepository.findByAnimeId(animeId);
    }

    @GetMapping("/{characterId}/anime")
    public AnimeDTO  getAnimeByCharacterId(@PathVariable int characterId) {
        return characterService.getAnimeByCharacterId(characterId);
    }
}

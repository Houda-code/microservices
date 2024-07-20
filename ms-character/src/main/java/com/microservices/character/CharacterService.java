package com.microservices.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private RestTemplate restTemplate;
    public void saveCharacter(CharacterRequest request) {
        Character character =Character.builder()
                .name(request.name())
                .description(request.description())
                .animeId(request.animeId())
                .build();
        characterRepository.save(character);
    }

    public Character getById(Integer id) {
        Optional<Character> character = characterRepository.findById(id);
        return character.orElseThrow(() -> new RuntimeException("Character not found with id: " + id));
    }

    public List<Character> getAll() {
        return characterRepository.findAll();
    }

    public AnimeDTO  getAnimeByCharacterId(int characterId) {
        Character character = characterRepository.findById(characterId).orElse(null);
        if (character != null && character.getAnimeId() != null) {
            String animeServiceUrl = "http://anime-service/animes/" + character.getAnimeId();
            return restTemplate.getForObject(animeServiceUrl, AnimeDTO .class);
        }
        return null;
    }



}

package com.microservices.anime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public record AnimeSrvice(AnimeRepository animeRepository,CharacterFeignClient characterFeignClient) {
//@Autowired
//private  AnimeRepository animeRepository;
//@Autowired
//private CharacterFeignClient characterFeignClient;


        public void saveAnime(AnimeRequest request) {
            Anime anime =Anime.builder()
                    .animeName(request.animeName())
                    .animeDescription(request.animeDescription())
                    .build();
            animeRepository.save(anime);
        }

    public Anime getById(String id) {
        Optional<Anime> anime = animeRepository.findById(id);
        return anime.orElseThrow(() -> new RuntimeException("Character not found with id: " + id));
    }

    public List<Anime> getAll() {
        return animeRepository.findAll();
    }

    public List<Character> getCharactersByAnimeId(String animeId) {
        return characterFeignClient.getCharactersByAnimeId(animeId);
    }


}

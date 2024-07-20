package com.microservices.character;

public record CharacterRequest(
         int id,
         String name,
         String description,
         String animeId
) {
}

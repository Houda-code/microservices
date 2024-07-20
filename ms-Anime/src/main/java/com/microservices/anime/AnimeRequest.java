package com.microservices.anime;

import java.util.List;

public record AnimeRequest(
         Integer id,
         String animeName,
         String animeDescription,
         List<String> caractereIds
) {
}

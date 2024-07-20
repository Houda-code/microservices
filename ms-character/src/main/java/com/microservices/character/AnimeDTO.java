package com.microservices.character;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AnimeDTO {
    private String id;
    private String animeName;
    private String animeDescription;
    private List<String> caractereIds;
}
package com.microservices.character;

//import com.microservices.anime.Anime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Character {
    @Id
    @SequenceGenerator(name="character_id_sequence",sequenceName = "character_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="character_id_sequence" )
    private int id;
    private String name;
    private String description;
    private String animeId;


}

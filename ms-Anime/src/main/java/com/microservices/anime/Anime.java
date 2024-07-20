package com.microservices.anime;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "Anime")
public class Anime {
    @Id
    private String id; // Changed to String for MongoDB compatibility
    private String animeName;
    private String animeDescription;
    private List<String> caractereIds;
}

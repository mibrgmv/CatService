package ru.cataccess.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.cataccess.objects.Breed;
import ru.cataccess.objects.Color;

@Data
@AllArgsConstructor
public class CatDTO {

    private Long id;

    private String name;

    private Breed breed;

    private Color color;

//    private OwnerDTO ownerDTO;
}

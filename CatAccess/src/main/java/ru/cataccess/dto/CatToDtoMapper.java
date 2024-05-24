package ru.cataccess.dto;

import org.springframework.stereotype.Component;
import ru.cataccess.entities.Cat;

@Component
public class CatToDtoMapper {

    public CatDTO convert(Cat cat) {
        return new CatDTO(cat.getId(), cat.getName(), cat.getBreed(), cat.getColor());
    }
}

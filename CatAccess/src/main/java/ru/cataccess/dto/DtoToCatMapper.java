package ru.cataccess.dto;

import org.springframework.stereotype.Component;
import ru.cataccess.entities.Cat;

@Component
public class DtoToCatMapper {

    public Cat convert(CatDTO catDTO) {
        return new Cat(catDTO.getId(), catDTO.getName(), catDTO.getBreed(), catDTO.getColor());
    }
}

package ru.owneraccess.dto;

import org.springframework.stereotype.Component;
import ru.owneraccess.entity.Owner;

@Component
public class OwnerToDtoMapper {

    public OwnerDTO convert(Owner owner) {
        return new OwnerDTO(owner.getId(), owner.getName(), owner.getDateOfBirth());
    }
}

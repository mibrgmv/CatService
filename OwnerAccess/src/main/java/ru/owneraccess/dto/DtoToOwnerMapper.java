package ru.owneraccess.dto;

import org.springframework.stereotype.Component;
import ru.owneraccess.entity.Owner;

@Component
public class DtoToOwnerMapper {

    public Owner convert(OwnerDTO ownerDTO) {
        return new Owner(ownerDTO.getId(), ownerDTO.getName(), ownerDTO.getDateOfBirth());
    }
}

package ru.owneraccess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.owneraccess.dto.DtoToOwnerMapper;
import ru.owneraccess.dto.OwnerDTO;
import ru.owneraccess.dto.OwnerToDtoMapper;
import ru.owneraccess.entity.Owner;
import ru.owneraccess.exceptions.OwnerNotFoundException;
import ru.owneraccess.service.OwnerService;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private OwnerToDtoMapper ownerToDtoMapper;

    @Autowired DtoToOwnerMapper dtoToOwnerMapper;

    @GetMapping()
    public List<OwnerDTO> getAllOwners() {
        return ownerService.getAll().stream().map(ownerToDtoMapper::convert).toList();
    }

    @GetMapping("/{ownerId}")
    public OwnerDTO getOwnerById(@PathVariable Long ownerId) {
        return ownerToDtoMapper.convert(ownerService.findById(ownerId).orElseThrow(() -> new OwnerNotFoundException(ownerId)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Owner createOwner(@RequestBody OwnerDTO ownerDTO) {
        return ownerService.save(dtoToOwnerMapper.convert(ownerDTO));
    }

    @DeleteMapping("/{ownerId}")
    public void deleteOwner(@PathVariable Long ownerId) {
        ownerService.deleteById(ownerId);
    }
}

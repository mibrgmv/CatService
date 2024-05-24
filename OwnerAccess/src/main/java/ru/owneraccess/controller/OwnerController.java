package ru.owneraccess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.owneraccess.entity.Owner;
import ru.owneraccess.exceptions.OwnerNotFoundException;
import ru.owneraccess.service.OwnerService;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping()
    public List<Owner> getAllOwners() {
        return ownerService.getAll();
    }

    @GetMapping("/{ownerId}")
    public Owner getOwnerById(@PathVariable Long ownerId) {
        return ownerService.findById(ownerId).orElseThrow(() -> new OwnerNotFoundException(ownerId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerService.save(owner);
    }

    @DeleteMapping("/{ownerId}")
    public void deleteOwner(@PathVariable Long ownerId) {
        ownerService.deleteById(ownerId);
    }
}

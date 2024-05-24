package ru.owneraccess.service;

import ru.owneraccess.entity.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    List<Owner> getAll();

    Optional<Owner> findById(Long ownerId);

    Owner save(Owner owner);

    void deleteById(Long ownerId);
}

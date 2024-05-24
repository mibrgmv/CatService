package ru.owneraccess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.owneraccess.entity.Owner;
import ru.owneraccess.repository.OwnerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BaseOwnerService implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

    @Override
    public Optional<Owner> findById(Long ownerId) {
        return ownerRepository.findById(ownerId);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void deleteById(Long ownerId) {
        ownerRepository.deleteById(ownerId);
    }
}

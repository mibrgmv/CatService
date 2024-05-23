package ru.cataccess.service;

import ru.cataccess.entities.Cat;

import java.util.List;
import java.util.Optional;

public interface CatService {

    List<Cat> getAll();

    Optional<Cat> findById(Long catId);

    Cat save(Cat cat);

    void deleteById(Long catId);
}

package ru.cataccess.services;

import ru.cataccess.entities.Cat;

import java.util.List;

public interface CatService {

    Cat getCat(Long catId);

    List<Cat> getAll();

    Cat saveCat(Cat cat);

    Cat updateCat(Cat cat);

    void deleteCat(Long catId);
}

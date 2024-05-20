package ru.cataccess.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cataccess.entities.Cat;
import ru.cataccess.repository.CatRepository;

import java.util.List;

@Service
public class BaseCatService implements CatService {

    @Autowired
    private CatRepository catRepository;

    @Override
    public Cat getCat(Long catId) {
        return null;
    }

    @Override
    public List<Cat> getAll() {
        return catRepository.findAll();
    }

    @Override
    public Cat saveCat(Cat cat) {
        return catRepository.save(cat);
    }

    @Override
    public Cat updateCat(Cat cat) {
        return null;
    }

    @Override
    public void deleteCat(Long catId) {
        catRepository.deleteById(catId);
    }
}

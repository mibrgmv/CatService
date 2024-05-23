package ru.cataccess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cataccess.entities.Cat;
import ru.cataccess.repository.CatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BaseCatService implements CatService {

    @Autowired
    private CatRepository catRepository;

    @Override
    public List<Cat> getAll() {
        return catRepository.findAll();
    }

    @Override
    public Optional<Cat> findById(Long catId) {
        return catRepository.findById(catId);
    }

    @Override
    public Cat save(Cat cat) {
        return catRepository.save(cat);
    }

    @Override
    public void deleteById(Long catId) {
        catRepository.deleteById(catId);
    }
}

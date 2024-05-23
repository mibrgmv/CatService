package ru.cataccess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.cataccess.entities.Cat;
import ru.cataccess.exceptions.CatNotFoundException;
import ru.cataccess.service.CatService;
import java.util.List;

@RestController
@RequestMapping("/api/cats")
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping()
    public List<Cat> getAllCats() {
        return catService.getAll();
    }

    @GetMapping("/{catId}")
    public Cat getCatById(@PathVariable Long catId) {
        return catService.findById(catId).orElseThrow(() -> new CatNotFoundException(catId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cat createCat(@RequestBody Cat cat) {
        return catService.save(cat);
    }

    @DeleteMapping("/{catId}")
    public void deleteCat(@PathVariable Long catId) {
        catService.deleteById(catId);
    }
}

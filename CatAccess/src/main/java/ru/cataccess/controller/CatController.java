package ru.cataccess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.cataccess.dto.CatDTO;
import ru.cataccess.dto.CatToDtoMapper;
import ru.cataccess.dto.DtoToCatMapper;
import ru.cataccess.entities.Cat;
import ru.cataccess.exceptions.CatNotFoundException;
import ru.cataccess.service.CatService;
import java.util.List;

@RestController
@RequestMapping("/api/cats")
public class CatController {

    @Autowired
    private CatService catService;

    @Autowired
    private CatToDtoMapper catToDtoMapper;

    @Autowired
    DtoToCatMapper dtoToCatMapper;

    @GetMapping()
    public List<CatDTO> getAllCats() {
        return catService.getAll().stream().map(catToDtoMapper::convert).toList();
    }

    @GetMapping("/{catId}")
    public CatDTO getCatById(@PathVariable Long catId) {
        return catToDtoMapper.convert(catService.findById(catId).orElseThrow(() -> new CatNotFoundException(catId)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cat createCat(@RequestBody CatDTO catDTO) {
        return catService.save(dtoToCatMapper.convert(catDTO));
    }

    @DeleteMapping("/{catId}")
    public void deleteCat(@PathVariable Long catId) {
        catService.deleteById(catId);
    }
}

package ru.cataccess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.cataccess.services.CatService;

@Controller
public class CatController {

    @Autowired
    private CatService catService;
}

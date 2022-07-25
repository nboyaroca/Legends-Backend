package com.legends.marketplace.controllers;

import com.legends.marketplace.models.Comic;
import com.legends.marketplace.services.ComicService;
import com.legends.marketplace.services.IComicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000/")
public class ComicController {

    private IComicService comicService;

    public ComicController(IComicService comicService) {
        this.comicService = comicService;
    }

    // Endpoint to get all comics
    @GetMapping("/comics")
    List<Comic> getAll() {
        return comicService.getAll();
    }

    @GetMapping("/comics/{id}")
    ResponseEntity<Comic> getById(@PathVariable Long id) {
        var comic = comicService.findById(id);
        return new ResponseEntity<>(comic, HttpStatus.OK);
    }

/*    @GetMapping("/comics/{id}")
    Comic getById(@PathVariable Long id) {
        Comic comic = this.comicService.findById(id);
        return comic;
    }*/
}

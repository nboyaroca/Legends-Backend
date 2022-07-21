package com.legends.marketplace.services;

import com.legends.marketplace.models.Comic;
import com.legends.marketplace.repositories.IComicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicService implements IComicService{

    private IComicRepository comicRepository;

    public ComicService(IComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    @Override
    public List<Comic> getAll() {
        return comicRepository.findAll();
    }
}

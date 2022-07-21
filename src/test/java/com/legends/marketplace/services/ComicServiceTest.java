package com.legends.marketplace.services;

import com.legends.marketplace.models.Comic;
import com.legends.marketplace.repositories.IComicRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ComicServiceTest {

    @Mock
    IComicRepository comicRepository;

    @Test

    void getAllShouldReturnAListOfComics() {
        var comicService = new ComicService(comicRepository);
        var comicList = List.of(new Comic(), new Comic());

        Mockito.when(comicRepository.findAll()).thenReturn(comicList);

        var sut = comicService.getAll();

        assertThat(sut.size(), equalTo(2));
    }
}
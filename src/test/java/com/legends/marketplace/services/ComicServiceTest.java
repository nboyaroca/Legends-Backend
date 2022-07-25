package com.legends.marketplace.services;

import com.legends.marketplace.models.Comic;
import com.legends.marketplace.repositories.IComicRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
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
        /*assertThat(sut.size(), equalTo(1)); TEST FAIL */
    }

    @Test
    void findByIdShouldReturnAComicWithSameParamId() {
        var comicService = new ComicService(comicRepository);
        var comic = new Comic();
        comic.setImg("image");
        comic.setName("title");
        comic.setIsbn("isbn");
        comic.setComicCondition("good condition");
        comic.setPrice(50.5);

        Mockito.when(comicRepository.findById(any(Long.class))).thenReturn(Optional.of(comic));

        var sut = comicService.findById(1L);

        assertThat(sut.getComicCondition(), equalTo(comic.getComicCondition()));
        /*assertThat(sut.getCondition(), equalTo("hello")); TEST FAIL */

    }

}


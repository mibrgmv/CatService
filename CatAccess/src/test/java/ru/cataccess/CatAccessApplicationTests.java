package ru.cataccess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.cataccess.entities.Cat;
import ru.cataccess.objects.Breed;
import ru.cataccess.objects.Color;
import ru.cataccess.service.CatService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class CatAccessApplicationTests {

    private CatService catService;

    @BeforeEach
    void setUp() {
        catService = Mockito.mock(CatService.class);
    }

    @Test
    public void testGetAllCats() {
        List<Cat> mockCats = new ArrayList<>();
        var cat_1 = new Cat("Whiskers", Breed.Siamese, Color.White);
        var cat_2 = new Cat("Mittens", Breed.Norwegian, Color.Multicolored);
        mockCats.add(cat_1);
        mockCats.add(cat_2);

        when(catService.getAll()).thenReturn(mockCats);

        List<Cat> actualCats = catService.getAll();

        Assertions.assertNotNull(actualCats);
        Assertions.assertEquals(2, actualCats.size());
        Assertions.assertTrue(actualCats.contains(cat_1));
        Assertions.assertTrue(actualCats.contains(cat_2));
    }

    @Test
    public void testFindById_ExistingId() {
        var mockedCat = new Cat("Snezhok", Breed.Siamese, Color.White);

        when(catService.findById(1L)).thenReturn(Optional.of(mockedCat));

        Optional<Cat> catOptional = catService.findById(1L);

        Assertions.assertTrue(catOptional.isPresent());
        Cat catActual = catOptional.get();
        Assertions.assertEquals(mockedCat, catActual);
    }

    @Test
    public void testFindById_NonexistentId() {
        var mockedCat = new Cat("Snezhok", Breed.Siamese, Color.White);

        when(catService.findById(1L)).thenReturn(Optional.of(mockedCat));

        Optional<Cat> catOptional = catService.findById(2L);

        Assertions.assertTrue(catOptional.isEmpty());
    }

    @Test
    public void testDeleteById() {
        doNothing().when(catService).deleteById(1L);

        catService.deleteById(1L);

        verify(catService, times(1)).deleteById(1L);
    }
}

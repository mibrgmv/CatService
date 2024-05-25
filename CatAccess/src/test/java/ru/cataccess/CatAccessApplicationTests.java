package ru.cataccess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.cataccess.entities.Cat;
import ru.cataccess.objects.Breed;
import ru.cataccess.objects.Color;
import ru.cataccess.service.BaseCatService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CatAccessApplicationTests {

    @Mock
    private BaseCatService mockService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCats() {
        List<Cat> mockCats = new ArrayList<>();
        var cat_1 = new Cat("Whiskers", Breed.Siamese, Color.White);
        var cat_2 = new Cat("Mittens", Breed.Norwegian, Color.Multicolored);
        mockCats.add(cat_1);
        mockCats.add(cat_2);

        when(mockService.getAll()).thenReturn(mockCats);

        List<Cat> actualCats = mockService.getAll();

        assertNotNull(actualCats);
        assertEquals(2, actualCats.size());
        assertTrue(actualCats.contains(cat_1));
        assertTrue(actualCats.contains(cat_2));
    }

    @Test
    public void testFindById_ExistingId() {
        var mockedCat = new Cat("Snezhok", Breed.Siamese, Color.White);

        when(mockService.findById(1L)).thenReturn(Optional.of(mockedCat));

        Optional<Cat> catOptional = mockService.findById(1L);

        assertTrue(catOptional.isPresent());
        Cat catActual = catOptional.get();
        assertEquals(mockedCat, catActual);
    }

    @Test
    public void testFindById_NonexistentId() {
        var mockedCat = new Cat("Snezhok", Breed.Siamese, Color.White);

        when(mockService.findById(1L)).thenReturn(Optional.of(mockedCat));

        Optional<Cat> catOptional = mockService.findById(2L);

        assertTrue(catOptional.isEmpty());
    }

    @Test
    public void testDeleteById() {
        doNothing().when(mockService).deleteById(1L);

        mockService.deleteById(1L);

        verify(mockService, times(1)).deleteById(1L);
    }
}

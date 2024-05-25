package ru.owneraccess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.owneraccess.entity.Owner;
import ru.owneraccess.service.BaseOwnerService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OwnerAccessApplicationTests {

    @Mock
    private BaseOwnerService mockService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll_WithOwners() {
        List<Owner> mockOwners = new ArrayList<>();
        mockOwners.add(new Owner(1L, "John Doe", LocalDate.of(1999, 10, 12)));
        mockOwners.add(new Owner(2L, "Will Smith", LocalDate.of(2002, 9,5)));

        when(mockService.getAll()).thenReturn(mockOwners);

        List<Owner> actualOwners = mockService.getAll();

        assertNotNull(actualOwners);
        assertEquals(2, actualOwners.size());
        assertEquals("John Doe", actualOwners.get(0).getName());
    }

    @Test
    public void testGetAll_EmptyList() {
        when(mockService.getAll()).thenReturn(Collections.emptyList());

        List<Owner> actualOwners = mockService.getAll();

        assertNotNull(actualOwners);
        assertTrue(actualOwners.isEmpty());
    }

    @Test
    public void testFindById_ExistingId() {
        Owner mockOwner = new Owner(1L, "Vova Petrov", LocalDate.of(2008, 1, 17));

        when(mockService.findById(1L)).thenReturn(Optional.of(mockOwner));

        Optional<Owner> actualOwnerOptional = mockService.findById(1L);

        assertTrue(actualOwnerOptional.isPresent());
        Owner actualOwner = actualOwnerOptional.get();
        assertEquals(1L, actualOwner.getId());
        assertEquals("Vova Petrov", actualOwner.getName());
    }

    @Test
    public void testFindById_NonexistentId() {
        when(mockService.findById(2L)).thenReturn(Optional.empty());

        Optional<Owner> actualOwnerOptional = mockService.findById(2L);

        assertFalse(actualOwnerOptional.isPresent());
    }

    @Test
    public void testSave_NewOwner() {
        Owner mockedOwner = new Owner("Bob Smith", LocalDate.of(2000, 10, 10));

        when(mockService.save(mockedOwner)).thenReturn(new Owner("Bob Smith", LocalDate.of(2000, 10, 10)));

        Owner savedOwner = mockService.save(mockedOwner);

        assertEquals(savedOwner, mockedOwner);
    }

    @Test
    public void testDeleteById_ExistingId() {
        doNothing().when(mockService).deleteById(1L);

        mockService.deleteById(1L);

        verify(mockService, times(1)).deleteById(1L);
    }

}

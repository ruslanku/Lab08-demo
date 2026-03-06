package com.example.lab08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

public class CustomListTest {
    @Test
    public void testHasCity() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);
        // This will fail initially because hasCity() doesn't exist
        assertTrue(list.hasCity(calgary));
    }

    @Test
    void testDeleteCity() {
        CustomList cityList = new CustomList();
        City city = new City("Edmonton", "Alberta");
        cityList.addCity(city);

        assertThrows(NoSuchElementException.class, () -> {
            cityList.deleteCity(new City("Edmonton", "Vancouver"));
        });
        cityList.deleteCity(city);
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testCountCities() {
        assertEquals(0, new CustomList().countCities());

        CustomList cityList = new CustomList();

        cityList.addCity(new City("Edmonton", "Alberta"));
        assertEquals(1, cityList.countCities());

        cityList.addCity(new City("Calgary", "Alberta"));
        assertEquals(2, cityList.countCities());
    }
}

package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    public CustomList MockCityList(){
        CustomList list = new CustomList(null, new ArrayList<>());
        return list;
    }
    @Test
    public void addCityTest(){
        CustomList list = MockCityList();
        int expectedCountBeforeAdd = 0;
        assertEquals(expectedCountBeforeAdd, list.getCount(), "Count should have been zero");
        City cityToAdd = new City("Nanton", "AB");
        list.addCity(cityToAdd);

        int expectedCountAfterAdd = 1;
        assertEquals(expectedCountAfterAdd, list.getCount(), "The City was not added");
    }

    @Test
    public void hasCityTest() {
        CustomList list = MockCityList();
        City cityToCheck = new City("Calgary", "AB");

        assertFalse(list.hasCity(cityToCheck), "City should not be found");

        list.addCity(cityToCheck);
        assertTrue(list.hasCity(cityToCheck), "City should be found after adding");
    }

    @Test
    public void deleteCityTest() {
        CustomList list = MockCityList();
        City cityToDelete = new City("Toronto", "ON");

        list.addCity(cityToDelete);
        assertTrue(list.hasCity(cityToDelete), "City should be in the list before deletion");

        list.delete(cityToDelete);
        assertFalse(list.hasCity(cityToDelete), "City should not be in the list after deletion");
    }

    @Test
    public void countCitiesTest() {
        CustomList list = MockCityList();

        // Initially, count should be zero
        assertEquals(0, list.countCities(), "Initial city count should be zero");

        // Add a city and check the count
        list.addCity(new City("Vancouver", "BC"));
        assertEquals(1, list.countCities(), "City count should be one after adding a city");

        // Add another city and check the count
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(2, list.countCities(), "City count should be two after adding another city");
    }

}

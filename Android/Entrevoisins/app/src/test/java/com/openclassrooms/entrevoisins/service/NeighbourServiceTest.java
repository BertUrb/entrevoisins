package com.openclassrooms.entrevoisins.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.Objects;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(Objects.requireNonNull(expectedNeighbours.toArray())));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void deleteNeighbourFromFavWithSuccess() {
        Neighbour neighbourToDeleteFromFav = service.getNeighbours().get(0);
        service.deleteNeighbourFromFav(neighbourToDeleteFromFav);
        assertFalse(service.getFavNeighbours().contains(neighbourToDeleteFromFav));
    }

    @Test
    public void addFavNeighbourWithSuccess() {
        Neighbour neighbourToFav = service.getNeighbours().get(6);
        assertFalse(service.getFavNeighbours().contains(neighbourToFav));
        service.addFavNeighbour(neighbourToFav);
        assertTrue(service.getFavNeighbours().contains(neighbourToFav));
    }
}

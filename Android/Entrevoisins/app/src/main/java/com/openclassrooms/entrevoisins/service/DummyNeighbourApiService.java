package com.openclassrooms.entrevoisins.service;

import android.util.Log;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> favneighbours = neighbours.subList(0,4);


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getFavNeighbours() {
        return favneighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
        Log.d("TAG", "deleteNeighbour: DELETE Neighbour");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbourFromFav(Neighbour neighbour) {
        favneighbours.remove(neighbour);
        Log.d("TAG", "deleteNeighbourFromFav: DELETE FAV");

    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addFavNeighbour(Neighbour neighbour) {
        favneighbours.add(neighbour);

    }
}

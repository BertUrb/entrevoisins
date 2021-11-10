package com.openclassrooms.entrevoisins.service;

import android.util.Log;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours;


    public DummyNeighbourApiService() {
        neighbours = DummyNeighbourGenerator.generateNeighbours();




    }


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
        List<Neighbour> favNeighbours = new ArrayList<>();

        for(Neighbour neighbour : neighbours)
        {
            if(neighbour.getFav())
            {
                favNeighbours.add(neighbour);
            }
        }
        return favNeighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbourFromFav(Neighbour neighbour) {

        neighbours.get(neighbours.indexOf(neighbour)).setFav(false);



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
       int index = neighbours.indexOf(neighbour);
        neighbours.get(index).setFav(true);

    }

}

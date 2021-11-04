package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Get FAVED  Neighbours
     * @return {@link List}
     */

    List<Neighbour> getFavNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Deletes a neighbour from fav
     * @param neighbour
     */
    void deleteNeighbourFromFav(Neighbour neighbour);

    /**
     * Create a neighbour
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);

    /**
     * Add a neighbour to fav
     * @param neighbour
     */
    void addFavNeighbour(Neighbour neighbour);


}

package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     *
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Get FAVED  Neighbours
     *
     * @return {@link List}
     */

    List<Neighbour> getFavNeighbours();

    /**
     * Deletes a neighbour
     *
     * @param neighbour Neighbour to delete
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Deletes a neighbour from fav
     *
     * @param neighbour Neighbour to delete from fav
     */
    void deleteNeighbourFromFav(Neighbour neighbour);

    /**
     * Create a neighbour
     *
     * @param neighbour Neighbour to créate
     */
    void createNeighbour(Neighbour neighbour);

    /**
     * Add a neighbour to fav
     *
     * @param neighbour Neighbour to fav
     */
    void addFavNeighbour(Neighbour neighbour);


}

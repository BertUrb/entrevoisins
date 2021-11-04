package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class DeleteNeighbourFromFavEvent {
    /**
     * Neighbour to delete
     */
    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour
     */
    public DeleteNeighbourFromFavEvent(Neighbour neighbour) {
        this.neighbour = neighbour;
    }
}


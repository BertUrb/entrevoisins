package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Event fired when a user deletes a Neighbour from favorites
 */
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


package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {

    public ListNeighbourPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     *
     * @param position 0 : Neighbour List / 1 : Fav List
     * @return the fragment
     */
    @Override
    public Fragment getItem(int position) {
        return NeighbourFragment.newInstance(position);
    }

    /**
     * get the number of pages
     *
     * @return Number of pages
     */
    @Override
    public int getCount() {
        return 2;
    }
}
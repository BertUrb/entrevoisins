package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.callback.OnClickNeighbourListener;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourFromFavEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_details.NeighbourDetailsActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class FavNeighbourFragment extends Fragment implements OnClickNeighbourListener {
    private NeighbourApiService mApiService;
    private RecyclerView mRecyclerView;
    private List<Neighbour> favNeighbours;

    /**
     * Create and return a new instance
     * @return @{@link FavNeighbourFragment}
     */
    public static FavNeighbourFragment newInstance() {
        return new FavNeighbourFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = DI.getNeighbourApiService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_neighbour_list, container, false);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        return view;
    }

    /**
     * Init the List of neighbours
     */
    private void initList() {
       favNeighbours = mApiService.getFavNeighbours();
        mRecyclerView.setAdapter(new MyNeighbourRecyclerViewAdapter(favNeighbours, this));
    }

    @Override
    public void onResume() {
        super.onResume();
        initList();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    /**
     * Fired if the user clicks on a delete button
     * @param event
     */
    @Subscribe
    public void onDeleteNeighbourFromFav(DeleteNeighbourFromFavEvent event) {
        mApiService.deleteNeighbourFromFav(event.neighbour);
        initList();
    }

    @Override
    public void onNeighbourClick(int position) {
        Intent playerDetailsIntent = new Intent(getContext(), NeighbourDetailsActivity.class);


        playerDetailsIntent.putExtra("Neighbour",favNeighbours.get( position));
        startActivity(playerDetailsIntent);
    }
}

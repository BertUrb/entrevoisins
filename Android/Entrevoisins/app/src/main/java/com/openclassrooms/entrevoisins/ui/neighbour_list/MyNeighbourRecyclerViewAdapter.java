package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.callback.OnClickNeighbourListener;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourFromFavEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyNeighbourRecyclerViewAdapter extends RecyclerView.Adapter<MyNeighbourRecyclerViewAdapter.ViewHolder> {

    private final List<Neighbour> mNeighbours;
    private final OnClickNeighbourListener onClickNeighbourListener;


    public MyNeighbourRecyclerViewAdapter(List<Neighbour> items, OnClickNeighbourListener onClickNeighbourListener) {
        mNeighbours = items;
        this.onClickNeighbourListener = onClickNeighbourListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_neighbour, parent, false);
        return new ViewHolder(view, onClickNeighbourListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Neighbour neighbour = mNeighbours.get(position);
        holder.mNeighbourName.setText(neighbour.getName());
        Glide.with(holder.mNeighbourAvatar.getContext())
                .load(neighbour.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mNeighbourAvatar);

        holder.mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager vp = v.getRootView().findViewById(R.id.container);
                if (vp.getCurrentItem() == 0) {
                    EventBus.getDefault().post(new DeleteNeighbourEvent(neighbour));
                    Log.d("TAG", "onClick: DELETE NEIGHBOUR");
                } else {
                    EventBus.getDefault().post(new DeleteNeighbourFromFavEvent(neighbour));
                    Log.d("TAG", "onClick: DELETE FAV");
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return mNeighbours.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.item_list_avatar)
        public ImageView mNeighbourAvatar;
        @BindView(R.id.item_list_name)
        public TextView mNeighbourName;
        @BindView(R.id.item_list_delete_button)
        public ImageButton mDeleteButton;

        private final OnClickNeighbourListener mOnClickNeighbourListener;


        public ViewHolder(View view, OnClickNeighbourListener onClickNeighbourListener) {
            super(view);
            mOnClickNeighbourListener = onClickNeighbourListener;
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnClickNeighbourListener.onNeighbourClick(getAdapterPosition());


        }
    }
}

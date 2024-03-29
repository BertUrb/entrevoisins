package com.openclassrooms.entrevoisins.ui.neighbour_details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NeighbourDetailsActivity extends AppCompatActivity {

    @BindView(R.id.neighbour_image)
    ImageView mNeighbourImage;
    @BindView(R.id.fav_button)
    ImageButton mFavButton;
    @BindView(R.id.neighbour_name)
    TextView mNeighbourName;
    @BindView(R.id.neighbour_name_2)
    TextView mNeighbourName2;
    @BindView(R.id.neighbour_address)
    TextView mAddress;
    @BindView(R.id.neighbour_site)
    TextView mSite;
    @BindView(R.id.neighbour_phone)
    TextView mPhone;
    @BindView(R.id.aboutMe)
    TextView mAboutMe;

    private Neighbour mNeighbour;
    private NeighbourApiService mApiService;

    @OnClick(R.id.fav_button)
    void ToggleFavNeighbour() {
        if (mNeighbour.getFav()) {
            mFavButton.setImageResource(R.drawable.ic_star_border_yellow_24);
            mApiService.deleteNeighbourFromFav(mNeighbour);
        } else {
            mFavButton.setImageResource(R.drawable.ic_star_yellow_24);
            mApiService.addFavNeighbour(mNeighbour);
        }
        mNeighbour.setFav(!mNeighbour.getFav());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_details);
        ButterKnife.bind(this);
        mApiService = DI.getNeighbourApiService();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle(null);

        initNeighbour();
    }

    /**
     * Init Neighbour
     */
    private void initNeighbour()
    {
        Intent intent = getIntent();
        mNeighbour = intent.getParcelableExtra("Neighbour");

        if (mNeighbour.getFav()) {
            mFavButton.setImageResource(R.drawable.ic_star_yellow_24);
        } else {
            mFavButton.setImageResource(R.drawable.ic_star_border_yellow_24);
        }

        mNeighbourName.setText(mNeighbour.getName());
        Glide.with(this)
                .load(mNeighbour.getAvatarUrl())
                .into(mNeighbourImage);
        mPhone.setText(mNeighbour.getPhoneNumber());
        mAboutMe.setText(mNeighbour.getAboutMe());
        mNeighbourName2.setText(mNeighbour.getName());
        mAddress.setText(mNeighbour.getAddress());
        String site = "https://facebook.com/" + mNeighbour.getName();
        mSite.setText(site);
    }
}
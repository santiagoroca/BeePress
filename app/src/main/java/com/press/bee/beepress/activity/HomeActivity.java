package com.press.bee.beepress.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.press.bee.beepress.Class.Post;
import com.press.bee.beepress.R;

import com.press.bee.beepress.base.BaseActivity;
import com.press.bee.beepress.config.RestInstance;
import com.press.bee.beepress.fragment.Publication;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

@EActivity
public class HomeActivity extends BaseActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.layout = R.layout.activity_home;
        super.onCreate(savedInstanceState);

        MapFragment mapFragment = (MapFragment) super.getFragmentManager().findFragmentById(R.id.map_container);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng sydney = new LatLng(-31.4286695, -64.1841196);

        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 17));
        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                return false;
            }
        });

        map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.sample_notification))
                .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                .position(new LatLng(-31.4288449, -64.1868543)));
    }

    @Background
    protected void fetch () {
        RInstance.rInterface.getClosePosts(new Callback<List<Post>>() {
            @Override
            public void success(List<Post> posts, Response response) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                for (Post post : posts) {
                    fragmentTransaction.add(R.id.publications_container, new Publication(post));
                }

                fragmentTransaction.commit();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


}

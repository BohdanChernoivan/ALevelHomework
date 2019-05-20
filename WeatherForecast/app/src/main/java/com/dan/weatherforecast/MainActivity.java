package com.dan.weatherforecast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.dan.weatherforecast.data.CityKharkiv;
import com.dan.weatherforecast.data.CityKyiv;
import com.dan.weatherforecast.data.base.CityDescription;
import com.dan.weatherforecast.data.url.CityURL;
import com.dan.weatherforecast.logic.AdapterURL;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private StaggeredGridLayoutManager mGridLayout;
    private RecyclerView recyclerView;
    private ArrayList<CityDescription> cityDescriptionArrayList;
    private AdapterURL adapterURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control();
        addCity();
        settingView();
    }

    private void control() {
        cityDescriptionArrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        adapterURL = new AdapterURL();
        mGridLayout = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
    }

    private void addCity() {
        for (int i = 0; i < 2; i++) {
            cityDescriptionArrayList.add(new CityKyiv(CityURL.getGetKyiv()));
            cityDescriptionArrayList.add(new CityKharkiv(CityURL.getGetKharkiv()));
        }
    }

    private void settingView() {
        recyclerView.setAdapter(adapterURL);
        adapterURL.updateList(cityDescriptionArrayList);
        adapterURL.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mGridLayout);
    }
}

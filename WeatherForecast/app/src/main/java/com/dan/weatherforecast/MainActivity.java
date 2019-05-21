package com.dan.weatherforecast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.dan.weatherforecast.data.cities.CityDnipro;
import com.dan.weatherforecast.data.cities.CityDonetsk;
import com.dan.weatherforecast.data.cities.CityKharkiv;
import com.dan.weatherforecast.data.cities.CityKyiv;
import com.dan.weatherforecast.data.base.CityDescription;
import com.dan.weatherforecast.data.cities.CityLviv;
import com.dan.weatherforecast.data.cities.CityOdessa;
import com.dan.weatherforecast.data.cities.CitySumy;
import com.dan.weatherforecast.data.cities.CityZaporizhia;
import com.dan.weatherforecast.data.url.CityURL;
import com.dan.weatherforecast.logic.AdapterURL;
import com.dan.weatherforecast.presenters.MainPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainPresenter.MainView {

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

    @Override
    public void control() {
        cityDescriptionArrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        adapterURL = new AdapterURL();
        mGridLayout = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
    }


    @Override
    public void addCity() {

        cityDescriptionArrayList.add(new CityKyiv(CityURL.getUrlKyiv()));
        cityDescriptionArrayList.add(new CityKharkiv(CityURL.getUrlKharkiv()));
        cityDescriptionArrayList.add(new CityOdessa(CityURL.getUrlOdessa()));
        cityDescriptionArrayList.add(new CityDnipro(CityURL.getUrlDnipro()));
        cityDescriptionArrayList.add(new CityDonetsk(CityURL.getUrlDonetsk()));
        cityDescriptionArrayList.add(new CitySumy(CityURL.getUrlSumy()));
        cityDescriptionArrayList.add(new CityZaporizhia(CityURL.getUrlZaporizhia()));
        cityDescriptionArrayList.add(new CityLviv(CityURL.getUrlLviv()));

    }

    @Override
    public void settingView() {
        recyclerView.setAdapter(adapterURL);
        adapterURL.updateList(cityDescriptionArrayList);
        adapterURL.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mGridLayout);
    }
}

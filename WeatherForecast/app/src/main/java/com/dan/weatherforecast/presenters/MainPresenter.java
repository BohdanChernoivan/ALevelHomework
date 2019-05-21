package com.dan.weatherforecast.presenters;

import com.dan.weatherforecast.data.base.CityDescription;
import com.dan.weatherforecast.presenters.base.BasePresenter;

import java.util.ArrayList;

public class MainPresenter extends BasePresenter {

    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }


    public interface MainView {
        void control();
        void addCity();
        void settingView();
    }
}

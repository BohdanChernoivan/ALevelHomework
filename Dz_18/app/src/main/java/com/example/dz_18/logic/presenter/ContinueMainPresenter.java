package com.example.dz_18.logic.presenter;

import android.view.View;

public class ContinueMainPresenter {

    private ContinueView continueView;

    public ContinueMainPresenter(ContinueView continueView) {
        this.continueView = continueView;
    }

    public interface ContinueView {

        void showNotification(View view);

        void addValueTwenty(View view);
    }
}

package com.dan.weatherforecast.presenters.base;

import java.lang.ref.WeakReference;

public class BasePresenter<T extends BaseViewAction> {


    WeakReference wRef = new WeakReference(null);

    public void setView(T view) {
        wRef = new WeakReference(view);
    }

    protected void sendActionToView(OnViewAction<T> viewActionInstance) {
        if (wRef.get() != null)
            viewActionInstance.doSomeActionWith((T) wRef.get());
    }

    interface OnViewAction<T extends BaseViewAction> {
        void doSomeActionWith(T view);
    }
}
package com.dan.weatherforecast.logic.diffUtils;

import android.support.v7.util.DiffUtil;

import com.dan.weatherforecast.data.base.CityDescription;

import java.util.List;

public class CityDiffUtils extends DiffUtil.Callback {

    private List<CityDescription> oldList;
    private List<CityDescription> newList;

    public CityDiffUtils(List<CityDescription> oldList, List<CityDescription> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int i, int i1) {
        return (oldList.get(i).hashCode() == newList.get(i1).hashCode());
    }

    @Override
    public boolean areContentsTheSame(int i, int i1) {
        return (oldList.get(i).equals(newList.get(i1)));
    }
}

package com.dan.weatherforecast.logic;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dan.weatherforecast.R;
import com.dan.weatherforecast.data.base.CityDescription;
import com.dan.weatherforecast.data.CityKharkiv;
import com.dan.weatherforecast.data.CityKyiv;
import com.dan.weatherforecast.logic.diffUtils.CityDiffUtils;
import com.dan.weatherforecast.logic.holder.KharkivHolder;
import com.dan.weatherforecast.logic.holder.KyivHolder;
import com.dan.weatherforecast.logic.holder.base.CityHolder;
import java.util.ArrayList;
import java.util.List;

public class AdapterURL extends RecyclerView.Adapter<CityHolder> {

    private final static int VIEW_TYPE_KYIV = 1;
    private final static int VIEW_TYPE_KHARKIV = 2;
    private final static int VIEW_TYPE_ODESSA = 3;
    private final static int VIEW_TYPE_DNIPRO = 4;
    private final static int VIEW_TYPE_DONETSK = 5;
    private final static int VIEW_TYPE_ZAPORIZHIA = 6;
    private final static int VIEW_TYPE_LVIV = 7;
    private final static int VIEW_TYPE_SUMY = 8;

    private ArrayList<CityDescription> city = new ArrayList<>();

    @NonNull
    @Override
    public CityHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            default:
                throw new RuntimeException("unknow type");
            case VIEW_TYPE_KYIV:
                return new KyivHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_form_city, viewGroup, false));
            case VIEW_TYPE_KHARKIV:
                return new KharkivHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_form_city, viewGroup, false));
//            case VIEW_TYPE_ODESSA:
//                return null;
//            case VIEW_TYPE_DNIPRO:
//                return null;
//            case VIEW_TYPE_DONETSK:
//                return null;
//            case VIEW_TYPE_ZAPORIZHIA:
//                return null;
//            case VIEW_TYPE_LVIV:
//                return null;
//            case VIEW_TYPE_SUMY:
//                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CityHolder cityHolder, int viewPosition) {
        if(cityHolder instanceof KyivHolder)
            ((KyivHolder) cityHolder).bind((CityKyiv) city.get(viewPosition));
        if (cityHolder instanceof KharkivHolder)
            ((KharkivHolder) cityHolder).bind((CityKharkiv) city.get(viewPosition));
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= city.size()) throw new RuntimeException("Wrong position");
        if (city.get(position) instanceof CityKyiv) return VIEW_TYPE_KYIV;
        if (city.get(position) instanceof CityKharkiv) return VIEW_TYPE_KHARKIV;
        throw new RuntimeException("unknow character");
    }

    @Override
    public int getItemCount() {
        return city.size();
    }

    public void updateList(List<CityDescription> cityDescriptions) {
        ArrayList<CityDescription> temp = new ArrayList<>();
        temp.addAll(this.city);
        this.city.clear();
        this.city.addAll(cityDescriptions);


        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new CityDiffUtils(temp, city));
        diffResult.dispatchUpdatesTo(this);
    }
}

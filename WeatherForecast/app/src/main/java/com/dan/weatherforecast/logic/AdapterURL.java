package com.dan.weatherforecast.logic;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.dan.weatherforecast.R;
import com.dan.weatherforecast.data.base.CityDescription;
import com.dan.weatherforecast.data.cities.CityDnipro;
import com.dan.weatherforecast.data.cities.CityDonetsk;
import com.dan.weatherforecast.data.cities.CityKharkiv;
import com.dan.weatherforecast.data.cities.CityKyiv;
import com.dan.weatherforecast.data.cities.CityLviv;
import com.dan.weatherforecast.data.cities.CityOdessa;
import com.dan.weatherforecast.data.cities.CitySumy;
import com.dan.weatherforecast.data.cities.CityZaporizhia;
import com.dan.weatherforecast.logic.diffUtils.CityDiffUtils;
import com.dan.weatherforecast.logic.holder.DniproHolder;
import com.dan.weatherforecast.logic.holder.DonetskHolder;
import com.dan.weatherforecast.logic.holder.KharkivHolder;
import com.dan.weatherforecast.logic.holder.KyivHolder;
import com.dan.weatherforecast.logic.holder.LvivHolder;
import com.dan.weatherforecast.logic.holder.OdessaHolder;
import com.dan.weatherforecast.logic.holder.SumyHolder;
import com.dan.weatherforecast.logic.holder.ZaporizhiaHolder;
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
            case VIEW_TYPE_ODESSA:
                return new OdessaHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_form_city, viewGroup, false));
            case VIEW_TYPE_DNIPRO:
                return new DniproHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_form_city, viewGroup, false));
            case VIEW_TYPE_DONETSK:
                return new DonetskHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_form_city, viewGroup, false));
            case VIEW_TYPE_ZAPORIZHIA:
                return new ZaporizhiaHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_form_city, viewGroup, false));
            case VIEW_TYPE_LVIV:
                return new LvivHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_form_city, viewGroup, false));
            case VIEW_TYPE_SUMY:
                return new SumyHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_form_city, viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CityHolder cityHolder, int viewPosition) {
        if(cityHolder instanceof KyivHolder)
            ((KyivHolder) cityHolder).bind((CityKyiv) city.get(viewPosition));
        if (cityHolder instanceof KharkivHolder)
            ((KharkivHolder) cityHolder).bind((CityKharkiv) city.get(viewPosition));
        if(cityHolder instanceof OdessaHolder)
            ((OdessaHolder) cityHolder).bind((CityOdessa) city.get(viewPosition));
        if (cityHolder instanceof DniproHolder)
            ((DniproHolder) cityHolder).bind((CityDnipro) city.get(viewPosition));
        if(cityHolder instanceof DonetskHolder)
            ((DonetskHolder) cityHolder).bind((CityDonetsk) city.get(viewPosition));
        if (cityHolder instanceof ZaporizhiaHolder)
            ((ZaporizhiaHolder) cityHolder).bind((CityZaporizhia) city.get(viewPosition));
        if(cityHolder instanceof LvivHolder)
            ((LvivHolder) cityHolder).bind((CityLviv) city.get(viewPosition));
        if (cityHolder instanceof SumyHolder)
            ((SumyHolder) cityHolder).bind((CitySumy) city.get(viewPosition));
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= city.size()) throw new RuntimeException("Wrong position");
        if (city.get(position) instanceof CityKyiv) return VIEW_TYPE_KYIV;
        if (city.get(position) instanceof CityKharkiv) return VIEW_TYPE_KHARKIV;
        if (city.get(position) instanceof CityOdessa) return VIEW_TYPE_ODESSA;
        if (city.get(position) instanceof CityDnipro) return VIEW_TYPE_DNIPRO;
        if (city.get(position) instanceof CityDonetsk) return VIEW_TYPE_DONETSK;
        if (city.get(position) instanceof CityZaporizhia) return VIEW_TYPE_ZAPORIZHIA;
        if (city.get(position) instanceof CityLviv) return VIEW_TYPE_LVIV;
        if (city.get(position) instanceof CitySumy) return VIEW_TYPE_SUMY;
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

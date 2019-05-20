package com.dan.weatherforecast.logic.holder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.dan.weatherforecast.R;
import com.dan.weatherforecast.data.CityKharkiv;
import com.dan.weatherforecast.logic.holder.base.CityHolder;

public class KharkivHolder extends CityHolder {

    private TextView textView;
    public KharkivHolder(@NonNull View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.txt_form_city);
    }

    public void bind(CityKharkiv cityKharkiv) {
        textView.setText(cityKharkiv.name);
    }
}

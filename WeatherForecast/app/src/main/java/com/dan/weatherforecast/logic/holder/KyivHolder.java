package com.dan.weatherforecast.logic.holder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dan.weatherforecast.R;
import com.dan.weatherforecast.data.CityKyiv;
import com.dan.weatherforecast.logic.holder.base.CityHolder;

public class KyivHolder extends CityHolder {

    private TextView textView;
    private ImageView imageView;

    public KyivHolder(@NonNull View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.txt_form_city);
       // itemView = itemView.findViewById(R.id.img_form_city);
    }

    public void bind(CityKyiv cityKyiv) {
        textView.setText(cityKyiv.name);
    }
}

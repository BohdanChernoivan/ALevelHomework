package com.dan.weatherforecast.logic.holder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dan.weatherforecast.R;
import com.dan.weatherforecast.data.cities.CityZaporizhia;
import com.dan.weatherforecast.logic.holder.base.CityHolder;
import com.squareup.picasso.Picasso;

public class ZaporizhiaHolder extends CityHolder {

    private TextView textView;
    private ImageView imageView;

    public ZaporizhiaHolder(@NonNull View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.txt_form_city);
        imageView = itemView.findViewById(R.id.img_form_city);

    }

    public void bind(CityZaporizhia cityZaporizhia) {
        textView.setText(cityZaporizhia.name);
        Picasso.get()
                .load(cityZaporizhia.getImgUrl())
                .error(R.drawable.ic_signal_wifi_off)
                .placeholder(R.drawable.ic_cloud_download)
                .into(imageView);
    }
}
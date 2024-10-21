package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount(){

        return cities.size();
    }

    public void addCity(City city) {
        if (cities != null) {
            cities.add(city);  // 将城市添加到列表中
        }
    }

    public boolean hasCity(City city) {
        return cities.contains(city);  // 检查城市是否存在于列表中
    }

    public void deleteCity(City city) {
        if (cities != null && cities.contains(city)) {
            cities.remove(city);  // 如果城市在列表中，移除该城市
        }
    }

    public int countCities() {
        return cities.size();  // 返回城市列表的大小
    }


}

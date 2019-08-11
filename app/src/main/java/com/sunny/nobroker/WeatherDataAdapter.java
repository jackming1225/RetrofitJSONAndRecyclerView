package com.sunny.nobroker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sunny.nobroker.model.WeatherData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class WeatherDataAdapter extends RecyclerView.Adapter<WeatherDataAdapter.CardViewHolder> {

    private List<WeatherData> weatherDataList;
    private Context mContext;

    public WeatherDataAdapter(List<WeatherData> noBrokersList, Context baseActivity) {
        this.weatherDataList = noBrokersList;
        this.mContext = baseActivity;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_property, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, int position) {
        final int holderPosition = holder.getAdapterPosition();
        WeatherData weatherData = weatherDataList.get(holderPosition);

        String rain = String.valueOf(weatherData.getRain()) + "%";
        String wind = String.valueOf(weatherData.getWind()) + "km/h" ;

        holder.tvRain.setText(rain);
        holder.tvWind.setText(wind);
        holder.tvTemperature.setText(String.valueOf(weatherData.getTemp()) + " \u2103");

        Date date = new java.util.Date(weatherData.getTime() * 1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM dd yyyy", Locale.US);
//        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-4"));
        String formattedDate = sdf.format(date);
        holder.tvDate.setText(formattedDate);


    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return weatherDataList.size();
    }


    public static class CardViewHolder extends RecyclerView.ViewHolder {

        LinearLayout llAllView;
        TextView tvRain, tvWind, tvTemperature, tvDate;

        private CardViewHolder(View itemView) {
            super(itemView);
            llAllView = itemView.findViewById(R.id.llAllView);
            tvRain = (TextView) itemView.findViewById(R.id.tvRain);
            tvWind = itemView.findViewById(R.id.tvWind);
            tvTemperature = itemView.findViewById(R.id.tvTemperature);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }
}

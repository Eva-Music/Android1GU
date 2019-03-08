package com.example.weatherwithfragments.cityrepository;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CityRepository {

    public static final List<TheCity> ITEMS = new ArrayList<>();

    private static final Map<String, TheCity> ITEM_MAP = new HashMap<>();

    static {
        addItem(createTheCity(ITEMS.size(), "Moscow", "12", "1", "12%", "2 м/с"));
        addItem(createTheCity(ITEMS.size(), "Saint-Petersburg", "5", "-2", "27%", "10 м/с"));
        addItem(createTheCity(ITEMS.size(), "Sochi", "18", "9", "30%", "11 м/с"));
        addItem(createTheCity(ITEMS.size(), "Samara", "15", "10", "8%", "6 м/с"));
    }

    private static void addItem(TheCity item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static TheCity createTheCity(int id, String cityName, String tempDay, String tempNight, String humProc, String windSpeed) {
        return new TheCity(String.valueOf(id), cityName, tempDay, tempNight, humProc, windSpeed);
    }

    public static class TheCity implements Serializable {
        public final String id;
        public final String content;
        public boolean isHumid;
        public boolean isWind;

        public String tempDay;
        public String tempNight;
        public String humProc;
        public String windSpeed;

        public TheCity(String id, String content, String tempDay, String tempNight, String humProc, String windSpeed) {
            this.id = id;
            this.content = content;
            this.tempDay = tempDay;
            this.tempNight = tempNight;
            this.humProc = humProc;
            this.windSpeed = windSpeed;
        }

        public boolean isHumid() {
            return isHumid;
        }

        public void setHumid(boolean humid) {
            isHumid = humid;
        }

        public boolean isWind() {
            return isWind;
        }

        public void setWind(boolean wind) {
            isWind = wind;
        }

        @NonNull
        @Override
        public String toString() {
            return "TheCity: " +
                    "id='" + id + '\'' +
                    ", content='" + content + '\'' +
                    ", isHumid=" + isHumid +
                    ", isWind=" + isWind;
        }
    }
}

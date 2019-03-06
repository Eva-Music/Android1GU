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
        addItem(createTheCity(ITEMS.size(), "Moscow"));
        addItem(createTheCity(ITEMS.size(), "Saint-Petersburg"));
        addItem(createTheCity(ITEMS.size(), "Sochi"));
        addItem(createTheCity(ITEMS.size(), "Samara"));
    }

    private static void addItem(TheCity item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static TheCity createTheCity(int id, String cityName) {
        return new TheCity(String.valueOf(id), cityName);
    }

    public static class TheCity implements Serializable {
        public final String id;
        public final String content;
        public boolean isHumid;
        public boolean isWind;

        TheCity(String id, String content) {
            this.id = id;
            this.content = content;

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

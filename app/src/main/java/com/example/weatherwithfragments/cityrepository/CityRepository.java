package com.example.weatherwithfragments.cityrepository;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class CityRepository {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<TheCity> ITEMS = new ArrayList<>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    private static final Map<String, TheCity> ITEM_MAP = new HashMap<>();

    static {
        // Add some sample items.

            addItem(createTheCity(ITEMS.size(), "Москва" ));
            addItem(createTheCity(ITEMS.size(), "Адлер" ));
        addItem(createTheCity(ITEMS.size(), "Южно-Курильск"));
            addItem(createTheCity(ITEMS.size(), "Красноярск" ));
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

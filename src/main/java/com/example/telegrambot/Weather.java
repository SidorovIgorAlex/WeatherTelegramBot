package com.example.telegrambot;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

public class Weather {

    public static String getWeather(String message, Model model) throws IOException {
        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + message + "&units=metric&appid=d78b7da6a4945d3906267f3806124c82");

        Scanner scanner = new Scanner((InputStream) url.getContent());
        String result = "";

        while (scanner.hasNext()) {
            result += scanner.next();
        }

        JSONObject jsonObject = new JSONObject(result);

        model.setName(jsonObject.getString("name"));

        JSONObject main = jsonObject.getJSONObject("main");
        model.setTemp(main.getDouble("temp"));
        model.setHumidity(main.getDouble("humidity"));

        Iterator<Object> weather = jsonObject.getJSONArray("weather").iterator();
        while (weather.hasNext()) {
            JSONObject jsonObjectArray = (JSONObject) weather.next();
            model.setIcon(jsonObjectArray.getString("icon"));
            model.setMain(jsonObjectArray.getString("main"));
        }

        return String.format("Город = %s,\nВлажность = %f,\nТемпература = %f", model.getName(), model.getHumidity(), model.getTemp());
    }

}

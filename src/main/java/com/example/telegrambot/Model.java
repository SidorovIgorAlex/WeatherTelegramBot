package com.example.telegrambot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Model {
    @JsonProperty("name")
    private String name;
    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("humidity")
    private Double humidity;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("main")
    private String main;
}

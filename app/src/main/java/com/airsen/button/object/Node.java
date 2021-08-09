package com.airsen.button.object;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Node {

    @SerializedName("station_id")
    @Expose
    private Long stationId;
    @SerializedName("aqi")
    @Expose
    private Integer aqi;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lon")
    @Expose
    private double lon;
    @SerializedName("content")
    @Expose
    private String content;

    public Node(int i, String s, double v, double v1, String s1) {
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public Integer getAqi() {
        return aqi;
    }

    public void setAqi(Integer aqi) {
        this.aqi = aqi;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Node{" +
                "stationId=" + stationId +
                ", aqi=" + aqi +
                ", lat=" + lat +
                ", lon=" + lon +
                ", content='" + content +
                '}';
    }
}
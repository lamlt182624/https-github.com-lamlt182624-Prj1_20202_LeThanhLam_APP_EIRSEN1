package com.airsen.button.object;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Record {

    @SerializedName("station_id")
    @Expose
    private Long stationId;
    @SerializedName("CO")
    @Expose
    private Object co;
    @SerializedName("CO2")
    @Expose
    private Object co2;
    @SerializedName("COA")
    @Expose
    private Object coa;
    @SerializedName("COW")
    @Expose
    private Object cow;
    @SerializedName("Humidity")
    @Expose
    private Double humidity;
    @SerializedName("NO2")
    @Expose
    private Object no2;
    @SerializedName("NO2A")
    @Expose
    private Object no2a;
    @SerializedName("NO2W")
    @Expose
    private Object no2w;
    @SerializedName("O3")
    @Expose
    private Object o3;
    @SerializedName("O3A")
    @Expose
    private Object o3a;
    @SerializedName("O3W")
    @Expose
    private Object o3w;
    @SerializedName("PM1")
    @Expose
    private Object pm1;
    @SerializedName("PM2p5")
    @Expose
    private Double pM2p5;
    @SerializedName("PM10")
    @Expose
    private Double pm10;
    @SerializedName("Pressure")
    @Expose
    private Object pressure;
    @SerializedName("SO2")
    @Expose
    private Object so2;
    @SerializedName("SO2A")
    @Expose
    private Object so2a;
    @SerializedName("SO2W")
    @Expose
    private Object so2w;
    @SerializedName("Temperature")
    @Expose
    private Double temperature;
    @SerializedName("Time")
    @Expose
    private Integer time;

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public Object getCo() {
        return co;
    }

    public void setCo(Object co) {
        this.co = co;
    }

    public Object getCo2() {
        return co2;
    }

    public void setCo2(Object co2) {
        this.co2 = co2;
    }

    public Object getCoa() {
        return coa;
    }

    public void setCoa(Object coa) {
        this.coa = coa;
    }

    public Object getCow() {
        return cow;
    }

    public void setCow(Object cow) {
        this.cow = cow;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Object getNo2() {
        return no2;
    }

    public void setNo2(Object no2) {
        this.no2 = no2;
    }

    public Object getNo2a() {
        return no2a;
    }

    public void setNo2a(Object no2a) {
        this.no2a = no2a;
    }

    public Object getNo2w() {
        return no2w;
    }

    public void setNo2w(Object no2w) {
        this.no2w = no2w;
    }

    public Object getO3() {
        return o3;
    }

    public void setO3(Object o3) {
        this.o3 = o3;
    }

    public Object getO3a() {
        return o3a;
    }

    public void setO3a(Object o3a) {
        this.o3a = o3a;
    }

    public Object getO3w() {
        return o3w;
    }

    public void setO3w(Object o3w) {
        this.o3w = o3w;
    }

    public Object getPm1() {
        return pm1;
    }

    public void setPm1(Object pm1) {
        this.pm1 = pm1;
    }

    public Double getPM2p5() {
        return pM2p5;
    }

    public void setPM2p5(Double pM2p5) {
        this.pM2p5 = pM2p5;
    }

    public Double getPm10() {
        return pm10;
    }

    public void setPm10(Double pm10) {
        this.pm10 = pm10;
    }

    public Object getPressure() {
        return pressure;
    }

    public void setPressure(Object pressure) {
        this.pressure = pressure;
    }

    public Object getSo2() {
        return so2;
    }

    public void setSo2(Object so2) {
        this.so2 = so2;
    }

    public Object getSo2a() {
        return so2a;
    }

    public void setSo2a(Object so2a) {
        this.so2a = so2a;
    }

    public Object getSo2w() {
        return so2w;
    }

    public void setSo2w(Object so2w) {
        this.so2w = so2w;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

}

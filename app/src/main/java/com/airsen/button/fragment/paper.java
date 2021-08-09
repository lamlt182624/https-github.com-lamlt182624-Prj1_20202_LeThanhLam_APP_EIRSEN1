package com.airsen.button.fragment;

public class paper {
    String address, warnning;
    int image;

    public paper(String address, String warnning, int image) {
        this.address = address;
        this.warnning = warnning;
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWarnning() {
        return warnning;
    }

    public void setWarnning(String warnning) {
        this.warnning = warnning;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

package com.airsen.button.ui;

public class yourfeedback {
    private String name;
    private String phone;
    private String address;
    private String mail;
    private String yourfeedback1;

    public yourfeedback(){

    }

    public yourfeedback(String name, String phone, String address, String mail, String yourfeedback1) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.mail = mail;
        this.yourfeedback1 = yourfeedback1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getYourfeedback1() {
        return yourfeedback1;
    }

    public void setYourfeedback1(String yourfeedback1) {
        this.yourfeedback1 = yourfeedback1;
    }
}

package com.example.ayberk.busreservationsystem;

public class Travel {
    String destinationCity;
    String originCity;
    String time;
    Double price;
    int year;
    int month;
    int day;

    public Travel(String destinationCity, String originCity, String time, Double price, int year, int month, int day) {
        this.destinationCity = destinationCity;
        this.originCity = originCity;
        this.time = time;
        this.price = price;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "destinationCity='" + destinationCity + '\'' +
                ", originCity='" + originCity + '\'' +
                ", time='" + time + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}

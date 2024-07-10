package com.oop.mahadi.demoshoping;

import java.io.Serializable;

public class Cartitems implements Serializable {
    String name;
    Float price;
    Integer vat,quanlity;

    public Cartitems() {
    }

    @Override
    public String toString() {
        return "Cartitems{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", vat=" + vat +
                ", quanlity=" + quanlity +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getVat() {
        return vat;
    }

    public void setVat(Integer vat) {
        this.vat = vat;
    }

    public Integer getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(Integer quanlity) {
        this.quanlity = quanlity;
    }

    public Cartitems(String name, Float price, Integer vat) {
        this.name = name;
        this.price = price;
        this.vat = vat;

    }
}

package com.oop.mahadi.demoshoping;

public class democlass {
    String product,price,quantity,vat,vatamount="",total="";

    public democlass(String product, String price, String quantity, String vat, String vatamount, String total) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.vat = vat;
        this.vatamount = vatamount;
        this.total = total;
    }

    public democlass() {
    }

    public democlass(String product, String price, String quantity, String vat) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.vat = vat;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getVatamount() {
        return vatamount;
    }

    public void setVatamount(String vatamount) {
        this.vatamount = vatamount;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}

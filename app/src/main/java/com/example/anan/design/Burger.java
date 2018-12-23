package com.example.anan.design;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }
    public abstract float price();
}

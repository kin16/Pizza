package com.hfad.pizza;

public class Pasta {
    private String name;
    private int resourceID;

    public static final Pasta[] pastas = {
            new Pasta("Spaghetti Bolognese", R.drawable.spaghetti),
            new Pasta("Lasagne", R.drawable.lasagne)
    };

    public Pasta(String name, int resourceID){
        this.name = name;
        this.resourceID = resourceID;
    }

    public String getName() {
        return name;
    }

    public int getResourceID() {
        return resourceID;
    }
}
package com.hfad.pizza;

public class Pizza {
    private String name;
    private int resourceID;

    public static final Pizza[] pizzas = {
            new Pizza("Diavolo", R.drawable.diavolo),
            new Pizza("Funghi", R.drawable.funghi),
            new Pizza("Spaghetti Bolognese", R.drawable.spaghetti),
            new Pizza("Lasagne", R.drawable.lasagne)
    };

    public Pizza(String name, int resourceID){
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

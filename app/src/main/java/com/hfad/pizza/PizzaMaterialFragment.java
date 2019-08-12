package com.hfad.pizza;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class PizzaMaterialFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pizzaRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_pizza_material, container, false);
        String[] pizzaNames = new String[2];
        for (int i = 0; i < 2; i++) {

            pizzaNames[i] = Pizza.pizzas[i].getName();
        }
        int[] pizzaImages = new int[2];
        for (int i = 0; i < 2; i++) {
            pizzaImages[i] = Pizza.pizzas[i].getResourceID();
        }
        ImageAdapter adapter = new ImageAdapter(pizzaNames, pizzaImages);
        pizzaRecycler.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        pizzaRecycler.setLayoutManager(manager);

        adapter.setListener(new ImageAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA, position);
                getActivity().startActivity(intent);
            }
        });

        return pizzaRecycler;
    }
}

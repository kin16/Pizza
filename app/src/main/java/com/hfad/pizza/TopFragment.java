package com.hfad.pizza;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class TopFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RelativeLayout layout = (RelativeLayout)
                inflater.inflate(R.layout.fragment_top, container, false);
        RecyclerView pizzaRecycler = (RecyclerView) layout.findViewById(R.id.pizza_recycler);
        String[] pizzaNames = new String[Pizza.pizzas.length];
        for (int i = 0; i < Pizza.pizzas.length; i++) {
            pizzaNames[i] = Pizza.pizzas[i].getName();
            //pizzaNames[i] = Pasta.pastas[i].getName();
        }
        int[] pizzaImages = new int[Pizza.pizzas.length];
        for (int i = 0; i < Pizza.pizzas.length; i++) {
            pizzaImages[i] = Pizza.pizzas[i].getResourceID();
            //pizzaImages[i] = Pasta.pastas[i].getResourceID();
        }
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecycler.setLayoutManager(layoutManager);
        ImageAdapter adapter = new ImageAdapter(pizzaNames, pizzaImages);
        pizzaRecycler.setAdapter(adapter);
        adapter.setListener(new ImageAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA, position);
                getActivity().startActivity(intent);
            }
        });
        return layout;
    }
}


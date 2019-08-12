package com.hfad.pizza;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PastaMaterialFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pastaRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_pasta_material, container, false);
        String[] pastaNames = new String[Pasta.pastas.length];
        for (int i = 0; i < pastaNames.length; i++) {
            pastaNames[i] = Pasta.pastas[i].getName();
        }
        int[] pastaImages = new int[Pasta.pastas.length];
        for (int i = 0; i < pastaImages.length; i++) {
            pastaImages[i] = Pasta.pastas[i].getResourceID();
        }
        ImageAdapter adapter = new ImageAdapter(pastaNames, pastaImages);
        pastaRecycler.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        pastaRecycler.setLayoutManager(manager);

        adapter.setListener(new ImageAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PastaDetailActivity.class);
                intent.putExtra(PastaDetailActivity.EXTRA, position);
                getActivity().startActivity(intent);
            }
        });

        return pastaRecycler;
    }
}

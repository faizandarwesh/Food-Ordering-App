package com.example.homepc.restauranteatitapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItalianFragment extends Fragment {


    public ItalianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_italian, container, false);


        ArrayList<ItalianClass> i_food = new ArrayList<ItalianClass>();
        i_food.add(new ItalianClass("Pasta", "450 Rs", R.drawable.pastaone,"0"));
        i_food.add(new ItalianClass("Lasagna", "650 Rs", R.drawable.lasagna,"0"));
        i_food.add(new ItalianClass("Italian Pizza", "1250 Rs", R.drawable.pizza,"0"));
        i_food.add(new ItalianClass("Focaccia Bread", "450 Rs", R.drawable.italiaone,"0"));

        ItalianAdapter cadapter = new ItalianAdapter(getActivity(),i_food);

        ListView listView = (ListView) view.findViewById(R.id.listview_italian);
        listView.setAdapter(cadapter);





        return view;
    }

}

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
public class TraditionalFragment extends Fragment {


    public TraditionalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_traditional, container, false);

        ArrayList<TraditionalfoodClass> trad_food = new ArrayList<TraditionalfoodClass>();
        trad_food.add(new TraditionalfoodClass("Karahi", "1250 Rs", R.drawable.karahi,"0"));
        trad_food.add(new TraditionalfoodClass("Biryani", "150 Rs", R.drawable.biryani,"0"));
        trad_food.add(new TraditionalfoodClass("Malai Boti", "450 Rs", R.drawable.malaiboti,"0"));
        trad_food.add(new TraditionalfoodClass("Seekh Kabab", "400 Rs", R.drawable.kabab,"0"));
        trad_food.add(new TraditionalfoodClass("Tikka", "250 Rs", R.drawable.tikka,"0"));
        trad_food.add(new TraditionalfoodClass("Sajji", "1550 Rs", R.drawable.sajjione,"0"));

        TraditionalFoodAdapter tradfoodadapter = new TraditionalFoodAdapter(getActivity(),trad_food);

        ListView listView = (ListView) view.findViewById(R.id.listview_traditional);
        listView.setAdapter(tradfoodadapter);

        return view;
    }

}

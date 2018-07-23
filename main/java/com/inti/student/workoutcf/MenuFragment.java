package com.inti.student.workoutcf;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {


    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_menu, container, false);

        String[] menuItems ={"Squats",
                            "Lunges",
                            "Plank",
                            "Push Ups",
                            "Single-leg Row"};

        ListView listView = (ListView) view.findViewById(R.id.menu);

        ArrayAdapter<String> ListViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1, menuItems
                 );

        listView.setAdapter(ListViewAdapter);  //DataBind ListView with items from Array Adapter


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent Squats = new Intent(getActivity(), SquatsActivity.class);
                    startActivity(Squats);
                } else if (position == 1) {
                    Intent Lunges = new Intent(getActivity(),LungesActivity.class);
                    startActivity(Lunges);
                }else if (position == 2){
                    Intent Plank = new Intent(getActivity(), PlankActivity.class);
                    startActivity(Plank);

                }else if (position == 3){
                    Intent PushUps = new Intent(getActivity(), PushUpsActivity.class);
                    startActivity(PushUps);

                }else if (position == 4){
                    Intent Singleleg = new Intent(getActivity(),SingleLegActivity.class);
                    startActivity(Singleleg);
                }
            }
        });
        return view; //Return the view
        }
}

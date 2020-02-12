package com.example.myfrag;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class BlankFragmentTwo extends Fragment {
    Fragment frag;
    Button button,button1;
    View root;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root= inflater.inflate(R.layout.fragment_blank_fragment_two, container, false);

        // Inflate the layout for this fragment
        button = root.findViewById(R.id.button3);
        button1 = root.findViewById(R.id.button4);
        // Inflate the layout for this fragment
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag= new BlankFragmentThree();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, frag);
                ft.commit();

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frag= new BlankFragmentOne();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, frag);
                ft.commit();

            }
        });

        return root;
    }

}

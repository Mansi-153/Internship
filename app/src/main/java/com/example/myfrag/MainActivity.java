package com.example.myfrag;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button button,button2,button3,button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button5=findViewById(R.id.button5);
        ActionBar ab = getSupportActionBar();
        ab.setLogo(R.mipmap.pump_round);
        ab.setTitle("Welcome");
        ab.setDisplayShowHomeEnabled(true);
        ab.setDisplayUseLogoEnabled(true);
    }
    public void btn(View view){
        Fragment frag;
        if(view==findViewById(R.id.button)){
            frag= new BlankFragmentOne();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, frag);
            ft.commit();
        }
        if(view==findViewById(R.id.button2)){
            frag = new BlankFragmentTwo();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, frag);
            ft.commit();


        }
        if(view==findViewById(R.id.button3)){
            frag = new BlankFragmentThree();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, frag);
            ft.commit();
        }
        if(view==findViewById(R.id.button5)){
            frag = new BlankFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, frag);
            ft.commit();
            button5.setVisibility(View.INVISIBLE);
        }
        button3.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);
    }
}

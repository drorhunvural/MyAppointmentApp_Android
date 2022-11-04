package com.example.myappointmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_final);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FirstFragment secondFragment = new FirstFragment();
        SecondFragment thirdfragment = new SecondFragment();
        Bundle bundle = new Bundle();

        bundle.putInt("position",position);
        secondFragment.setArguments(bundle);
        thirdfragment.setArguments(bundle);


        if(position==0) {
            fragmentTransaction.add(R.id.frame_secondactivity, secondFragment); // secondactivity
            fragmentTransaction.commit();

        }

        if(position==2) {
            fragmentTransaction.add(R.id.frame_secondactivity, thirdfragment); // secondactivity
            fragmentTransaction.commit();
        }

    }
}
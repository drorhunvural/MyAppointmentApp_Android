package com.example.myappointmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
// I changed here at 4:10 PM
public class MainActivity extends AppCompatActivity {
    TextView textView2,textView7;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MyListFragment myListFragment = new MyListFragment();
        fragmentTransaction.add(R.id.frame_secondactivity,myListFragment);
        fragmentTransaction.commit();

        textView2 = findViewById(R.id.textView2);

        textView7 = findViewById(R.id.textView7);




// Getting data by using intent. There is no permanent show
//        Intent intent = getIntent();
//        String gender = intent.getStringExtra("key1");
//        String name = intent.getStringExtra("key2");
//        String age = intent.getStringExtra("key3");
//        String symptoms = intent.getStringExtra("key4");

        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        String name2 = sharedPreferences.getString("key name",null);
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        String gender2 = sharedPreferences.getString("key gender",null);
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        String age2 = sharedPreferences.getString("key age",null);

        textView2.setText("Name= " + name2 + "\n"+ " Gender="+gender2+ "\n"+" Age="+age2+"\n");

        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        String symptoms2 = sharedPreferences.getString("Symptoms",null);
        textView7.setText(" Symptoms="+symptoms2);







    }
}
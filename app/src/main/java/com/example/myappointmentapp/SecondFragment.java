package com.example.myappointmentapp;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;


public class SecondFragment extends Fragment {

    SharedPreferences sharedPreferences;
    ImageView imageview;
    Button doneButton;
    CheckBox ch0, ch1, ch2, ch3, ch4, ch5, ch6 ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_third_, container, false);

        imageview = view.findViewById(R.id.imageView);
        doneButton = (Button) view.findViewById(R.id.donesymtomps);
        ch0=view.findViewById(R.id.checkBoxdizzy);
        ch1=view.findViewById(R.id.checkBoxfever);
        ch2=view.findViewById(R.id.checkBoxheadache);
        ch3=view.findViewById(R.id.checkBoxcough);
        ch4=view.findViewById(R.id.checkBoxdiarrhea);
        ch5=view.findViewById(R.id.checkBoxvomitting);
        ch6=view.findViewById(R.id.checkBoxfatigue);


        Bundle bundle = getArguments();
        int position = bundle.getInt("position",0);

        if(position==2) {

            imageview.setImageResource(R.drawable.android2);
        }

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                if(ch0.isChecked())
                    intent.putExtra("key4", ch0.getText().toString());
                if(ch1.isChecked())
                    intent.putExtra("key4", ch1.getText().toString());
                if(ch2.isChecked())
                    intent.putExtra("key4", ch2.getText().toString());
                if(ch3.isChecked())
                    intent.putExtra("key4", ch3.getText().toString());
                if(ch4.isChecked())
                    intent.putExtra("key4", ch4.getText().toString());
                if(ch5.isChecked())
                    intent.putExtra("key4", ch5.getText().toString());
                if(ch6.isChecked())
                    intent.putExtra("key4", ch6.getText().toString());

                startActivity(intent);

                saveData();
            }
        });
        return view;

    }

    public void saveData(){

        sharedPreferences = getActivity().getSharedPreferences("saveData", MODE_PRIVATE);


        SharedPreferences.Editor editor = sharedPreferences.edit();


        if(ch0.isChecked())

        editor.putString("Symptoms",ch0.getText().toString());
        if(ch1.isChecked())
            editor.putString("Symptoms",ch1.getText().toString());
        if(ch2.isChecked())
            editor.putString("Symptoms",ch2.getText().toString());
        if(ch3.isChecked())
            editor.putString("Symptoms",ch3.getText().toString());
        if(ch4.isChecked())
            editor.putString("Symptoms",ch4.getText().toString());
        if(ch5.isChecked())
            editor.putString("Symptoms",ch5.getText().toString());
        if(ch6.isChecked())
            editor.putString("Symptoms",ch6.getText().toString());


        editor.commit();

        Toast.makeText(getActivity(),"Saved Data",Toast.LENGTH_SHORT).show();
    }
}
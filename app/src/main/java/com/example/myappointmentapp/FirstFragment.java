package com.example.myappointmentapp;

import android.app.assist.AssistStructure;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class FirstFragment extends Fragment {
    public static final String My_PREF = "My_PREF";


    SharedPreferences sharedPreferences;
    TextView textView2;
    ImageView imageview;
    Button doneButton;
    RadioButton maleRButton, femaleRButton;
    private RadioButton radioSexButton;
    private RadioGroup radioSexGroup;
    EditText editTextTextPersonName,editTextNumber;
    //TextView editTextTextMultiLine;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_second, container, false);

        imageview = view.findViewById(R.id.imageView);

        Bundle bundle = getArguments();
        int position = bundle.getInt("position",0);
        doneButton = (Button) view.findViewById(R.id.button);
        maleRButton = view.findViewById(R.id.maleRButton);
        femaleRButton = view.findViewById(R.id.femaleRButton);

        textView2 = view.findViewById(R.id.textView2);
        radioSexGroup = view.findViewById(R.id.radioSex);
        editTextTextPersonName = view.findViewById(R.id.editTextTextPersonName);
        editTextNumber = view.findViewById(R.id.editTextNumber);

        if(position==0) {

            imageview.setImageResource(R.drawable.android);

        }


        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioSexGroup.getCheckedRadioButtonId();
                radioSexButton = view.findViewById(selectedId);

                saveData();
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);

//// Sending data by using intent. There is no permanent show
//
//                if(maleRButton.isChecked()) {
//                    intent.putExtra("key1", maleRButton.getText().toString());
//                }
//                if(femaleRButton.isChecked()) {
//                    maleRButton.setSelected(false);
//                    intent.putExtra("key1", femaleRButton.getText().toString());
//                }
//
//                intent.putExtra("key2", editTextTextPersonName.getText().toString());
//                intent.putExtra("key3", editTextNumber.getText().toString());
//
            }
        });

        return view;

    }

    public void saveData(){

        sharedPreferences = getActivity().getSharedPreferences("saveData", MODE_PRIVATE);

        String name = editTextTextPersonName.getText().toString();
        String age = editTextNumber.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key name",name);
        editor.putString("key age",age);
        if(maleRButton.isChecked()) {

            String gender = maleRButton.getText().toString();
            editor.putString("key gender",gender);

        }
        if(femaleRButton.isChecked()) {
            maleRButton.setSelected(false);
            String gender = femaleRButton.getText().toString();
            editor.putString("key gender",gender);
        }

        editor.commit();

        Toast.makeText(getActivity(),"Saved Data",Toast.LENGTH_SHORT).show();
    }

}
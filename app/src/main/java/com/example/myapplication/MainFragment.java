package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        EditText editPassword = view.findViewById(R.id.editPassword);
        CheckBox checkBox = view.findViewById(R.id.showPasswordCheckBox);

        checkBox.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (!isChecked) {
                editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            } else {
                editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        });
        return view;
    }
}
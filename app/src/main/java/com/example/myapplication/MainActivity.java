package com.example.myapplication;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Fragment mainFragment;
    private Fragment resultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = new MainFragment();
        resultFragment = new ResultFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.mainContainer, mainFragment);
        fragmentTransaction.replace(R.id.resultContainer, resultFragment);
        fragmentTransaction.commit();
    }

    public void onClick(View view) {
        String login = ((EditText) mainFragment.getView().findViewById(R.id.editLogin)).getText().toString();
        String password = ((EditText) mainFragment.getView().findViewById(R.id.editPassword)).getText().toString();

        if (login.trim().isEmpty() || password.trim().isEmpty()) {
            Toast toast = Toast.makeText(view.getContext(), "Login or password is empty!", Toast.LENGTH_LONG);
            toast.show();
        } else {
            ((TextView) resultFragment.getView().findViewById(R.id.loginResult)).setText(login);
            ((TextView) resultFragment.getView().findViewById(R.id.passwordResult)).setText(password);
        }
    }
}
package com.example.truckdriver.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.truckdriver.R;
import com.example.truckdriver.database.MyDB;
import com.example.truckdriver.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private MyDB myDB;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myDB = new MyDB(binding.getRoot().getContext());
        login();
    }
//    bu test

    private void login() {
        // loading(true);
        binding.buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading(true);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
                String username = binding.inputEmail.getText().toString().trim();
                String name = binding.inputPassword.getText().toString().trim();
                if (username.isEmpty() && name.isEmpty()) {
                    showToast("Введите данные полностью.");
                    loading(false);
                } else {
                    if (myDB.checkUserNamePassword(username, name)) {
                        loading(false);
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    } else {
                        loading(false);
                        showToast("Данный пользователь не зарегистрирован");
                    }

                }
            }
        });
    }

    private void loading(Boolean isLoading) {
        if (isLoading) {
            binding.buttonSignIn.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            binding.progressBar.setVisibility(View.INVISIBLE);
            binding.buttonSignIn.setVisibility(View.VISIBLE);
        }
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


}
package com.example.team1customlistviewcardflatlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.team1customlistviewcardflatlist.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null) {

            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("phone");
            String country = intent.getStringExtra("country");
            int imageId = intent.getIntExtra("imageId",R.drawable.avatar1);

            binding.nameProfile.setText(name);
            binding.phoneProfile.setText(phone);
            binding.countryProfile.setText(country);
            binding.profileImage.setImageResource(imageId);
        }
    }
}
package com.experion.sampleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ascent.sampleproject.R;
import com.ascent.sampleproject.databinding.ActivityMainBinding;
import com.experion.sampleproject.withoutvm.WithoutVMActivity;
import com.experion.sampleproject.withvm.WithVMActivity;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.with.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WithVMActivity.class);
                startActivity(intent);
            }
        });

        binding.without.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WithoutVMActivity.class);
                startActivity(intent);
            }
        });
    }
}

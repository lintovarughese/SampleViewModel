package com.experion.sampleproject.withoutvm;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

import com.ascent.sampleproject.R;
import com.ascent.sampleproject.databinding.ActivityWithoutVmBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class WithoutVMActivity extends AppCompatActivity {

    private ActivityWithoutVmBinding binding;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_without_vm);

        timer = new CountDownTimer(301000, 1000) {
            public void onTick(long millisUntilFinished) {
                binding.textView.setText(Long.toString(millisUntilFinished / 1000));

            }

            public void onFinish() {

            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}



package com.experion.sampleproject.withvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.ascent.sampleproject.R;
import com.ascent.sampleproject.databinding.ActivityWithVmBinding;

public class WithVMActivity extends AppCompatActivity {
    private ActivityWithVmBinding binding;
    private TimerViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_with_vm);
        mViewModel = ViewModelProviders.of(this).get(TimerViewModel.class);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mViewModel.getLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textView.setText(s);
            }
        });
    }
}

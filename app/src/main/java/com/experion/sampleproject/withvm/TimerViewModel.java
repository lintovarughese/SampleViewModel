package com.experion.sampleproject.withvm;


import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TimerViewModel extends ViewModel {
    private String TAG = "TimerViewModel";
    private MutableLiveData<String> liveData = new MutableLiveData<>();
    private CountDownTimer timer;

    public LiveData<String> getLiveData() {
        return liveData;
    }

    public TimerViewModel() {
        startTimer();
    }

    private void startTimer(){
        timer = new CountDownTimer(301000, 1000) {
            public void onTick(long millisUntilFinished) {
                if(liveData != null){
                    liveData.setValue(Long.toString(millisUntilFinished / 1000));
                    Log.d(TAG, Long.toString(millisUntilFinished / 1000));
                }
            }

            public void onFinish() {

            }
        }.start();
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if(timer != null){
            timer.cancel();
        }
    }
}

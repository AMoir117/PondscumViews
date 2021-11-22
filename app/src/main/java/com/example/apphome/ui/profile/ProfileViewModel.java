package com.example.apphome.ui.profile;

import android.widget.ImageView;
import java.util.List;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {

    private ImageView image;
    private MutableLiveData<String> mText;

    public ProfileViewModel() {

        // this is where we add elements

        mText = new MutableLiveData<>();
//        mText.setValue("This is profile fragment");




    }


    public LiveData<String> getText() {
        return mText;
    }
}
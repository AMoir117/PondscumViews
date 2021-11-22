package com.example.apphome.ui.feed;

import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.apphome.MainActivity;

public class FeedViewModel extends ViewModel {



    private MutableLiveData<String> mText;

    public FeedViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("This is feed fragment");



    }

    public LiveData<String> getText() {
        return mText;
    }
}


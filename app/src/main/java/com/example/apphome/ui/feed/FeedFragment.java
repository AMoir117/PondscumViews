package com.example.apphome.ui.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apphome.MainActivity;
import com.example.apphome.databinding.FragmentFeedBinding;

public class FeedFragment extends Fragment {

    private FeedViewModel feedViewModel;
    private FragmentFeedBinding binding;

    private TextView appName;
    private TextView notificationText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        feedViewModel =
                new ViewModelProvider(this).get(FeedViewModel.class);

        binding = FragmentFeedBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        appName = binding.appName;
        appName.setText("Discord");

        appName = binding.appName2;
        appName.setText("Twitter");

        appName = binding.appName3;
        appName.setText("Instagram");

        // set text size (not sure how to do this in a for loop for each frame)
        int textSize = ((MainActivity)getActivity()).getTextSize();
        binding.notificationText.setTextSize(textSize);
        binding.notificationText2.setTextSize(textSize);
        binding.notificationText3.setTextSize(textSize);
        binding.notificationText4.setTextSize(textSize);
        binding.notificationText5.setTextSize(textSize);
        binding.notificationText6.setTextSize(textSize);
        binding.notificationText7.setTextSize(textSize);
        binding.notificationText8.setTextSize(textSize);
        binding.notificationText9.setTextSize(textSize);





//        final TextView textView = binding.textFeed;
//        feedViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}


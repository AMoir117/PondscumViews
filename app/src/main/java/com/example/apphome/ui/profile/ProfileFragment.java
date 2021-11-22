package com.example.apphome.ui.profile;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.apphome.MainActivity;
import com.example.apphome.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private ProfileViewModel homeViewModel;
    private FragmentProfileBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textProfile;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        // set text size
        int textSize = ((MainActivity)getActivity()).getTextSize();
        binding.connectApp.setTextSize(textSize);
        binding.connectedApps.setTextSize(textSize);


        final ImageView image = binding.imageProfile;


        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        // handles view objects

//        View root = binding.getRoot();
//        final ImageView image = binding.imageView2;



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
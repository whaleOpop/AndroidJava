package com.android.java.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.android.java.R;
import com.android.java.databinding.FragmentHomeBinding;
import com.android.java.entity.Action;
import com.android.java.saveload.Load;
import com.android.java.saveload.SaveAction;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private Action action;
    SaveAction save = new SaveAction();
    Load load = new Load();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        action = load.read(requireContext());


        HomeViewModel homeViewModel = new HomeViewModel();
        final TextView description = binding.Description;
        homeViewModel.getText().observe(getViewLifecycleOwner(), value -> {
            String descriptionStr = "" + action.getActionDescription() + "\n\n\n" + action.getActionActionStatus();

            description.setText(descriptionStr);

        });
        Button start = binding.Start;
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                action.setActionActionStatus("В процессе");


                save.saveAction(requireContext(), action);

                Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_navigation_action, getBungleAction());


            }
        });
        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    Bundle getBungleAction() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("Action", action);
        return bundle;
    }

}
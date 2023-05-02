package com.android.java.ui.action;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.java.MainActivity;
import com.android.java.R;


import com.android.java.adapter.ActionAdapter;
import com.android.java.databinding.FragmentActionBinding;
import com.android.java.entity.Action;
import com.android.java.entity.ActionList;
import com.android.java.entity.ActionPart;
import com.android.java.saveload.Load;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ActionFragment extends Fragment {

    private FragmentActionBinding binding;
    private Action action;

    public RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private ActionAdapter actionAdapter;
    Load load = new Load();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        action = load.read(requireContext());
        Bundle bundle = this.getArguments();
        assert bundle != null;
        action = (Action) bundle.getSerializable("Action");
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ActionViewModel actionViewModel =
                new ViewModelProvider(this).get(ActionViewModel.class);


        binding = FragmentActionBinding.inflate(inflater, container, false);


        View root = binding.getRoot();

        final TextView textView = binding.actionName;

        actionAdapter = new ActionAdapter(action.getActionParts());
        recyclerView = binding.recyclerViw;
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(actionAdapter);


        actionViewModel.getText().observe(getViewLifecycleOwner(), value -> {
            textView.setText(action.getActionDescription());
            recyclerView.setAdapter(actionAdapter);
            Picasso.get().load(action.getActionUrlImage()).resize(83, 53).into(binding.previewAction);

        });

        return root;
    }

    @Override
    public void onStop() {
        binding = null;
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
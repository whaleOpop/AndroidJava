package com.android.java.ui.action;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.android.java.R;
import com.android.java.databinding.FragmentActionBinding;
import com.android.java.databinding.FragmentActionPartBinding;
import com.android.java.entity.Action;
import com.android.java.entity.ActionList;
import com.android.java.entity.ActionPart;
import com.android.java.saveload.Load;

import com.android.java.saveload.SaveAction;
import com.android.java.ui.action.ActionViewModel;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class ActionPartFragment extends Fragment {
    private FragmentActionPartBinding binding;
    Integer count = 0;
    ActionPart actionPart;
    Action action;

    Load load = new Load();
    int postition=1;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ActionViewModel actionPartViewModel =
                new ViewModelProvider(this).get(ActionViewModel.class);

        Bundle bundle = this.getArguments();


        assert bundle != null;
        postition = bundle.getInt("Position");
        actionPart = (ActionPart) bundle.getSerializable("ActionPart");
        action = load.read(requireContext());
        count = bundle.getInt("Count");


        binding = FragmentActionPartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TextView nameAction = binding.actionPartName;
        TextView progress = binding.progress;
        TextView name = binding.name;
        TextView ingre = binding.indegr;
        Button next = binding.next;
        actionPartViewModel.getText().observe(getViewLifecycleOwner(), value -> {
            int progressStr = (count + 1);
            String Progress = actionPart.getActionLists().get(count).getActionItemstatus() + progressStr + "/" + actionPart.getActionLists().size();
            progress.setText(Progress);
            Picasso.get().load(actionPart.getActionLists().get(count).getActionImageUrl()).resize(270, 246).into(binding.previewAction);

            nameAction.setText(actionPart.getName());
            name.setText(actionPart.getActionLists().get(count).getActionItemDescription());
            ingre.setText(actionPart.getActionLists().get(count).getActionItemName());

            if (count == actionPart.getActionLists().size() - 1) {
                next.setText("Завершить");
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        count++;
                        SaveAction save = new SaveAction();
                        action.getActionParts().get(postition).setCheckBox(true);
                        save.saveAction(requireContext(), action);
                        Navigation.findNavController(v).navigate(R.id.action_navigation_action_part_to_navigation_action,  getBungleSaveActionPart());

                    }
                });
            } else {
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        count++;
                        Navigation.findNavController(v).navigate(R.id.action_navigation_action_part_self, getBungleAction());
                    }
                });
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
        Bundle bundle = this.getArguments();
        assert bundle != null;
        bundle.putSerializable("ActionPart", actionPart);
        bundle.putInt("Count", count);
        return bundle;
    }

    Bundle getBungleSaveActionPart() {
        Bundle bundle = this.getArguments();
        assert bundle != null;
        bundle.putSerializable("Action", action);
        return bundle;
    }
}

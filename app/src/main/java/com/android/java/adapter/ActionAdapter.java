package com.android.java.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.java.R;
import com.android.java.entity.ActionPart;

import java.io.Serializable;
import java.util.List;

public class ActionAdapter extends RecyclerView.Adapter<ActionViewHolder> implements Serializable {


    private List<ActionPart> actionParts;

    @NonNull
    @Override
    public ActionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.button_item, parent, false);

        return new ActionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActionViewHolder holder, int position) {
        holder.bind(actionParts.get(position).getName(), actionParts.get(position).getShortDesp(), actionParts.get(position).getImageUrl(), actionParts.get(position).getCheckBox());
        holder.ChangeForm(actionParts.get(position));

    }


    public ActionAdapter(List<ActionPart> actionParts) {
        this.actionParts = actionParts;

    }

    @Override
    public int getItemCount() {
        return actionParts.size();
    }
}

package com.android.java.adapter;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.android.java.R;
import com.android.java.entity.Action;
import com.android.java.entity.ActionPart;
import com.squareup.picasso.Picasso;

public class ActionViewHolder extends RecyclerView.ViewHolder {

    TextView Actionnamepart;
    TextView ActionshortDescr;
    ImageView Actionpartimage;
    ImageView ActionCheckBox;

    CardView item;

    public ActionViewHolder(@NonNull View itemView) {
        super(itemView);
        item = itemView.findViewById(R.id.item);
        Actionnamepart = itemView.findViewById(R.id.namepart);
        ActionshortDescr = itemView.findViewById(R.id.shortDescr);
        Actionpartimage = itemView.findViewById(R.id.actionpartimage);
        ActionCheckBox = itemView.findViewById(R.id.checkbox);
    }

    public void bind(String name, String Descr, String Image, Boolean checkbox) {
        Actionnamepart.setText(name);
        ActionshortDescr.setText(Descr);
        Picasso.get().load(Image).resize(90, 90).into(Actionpartimage);

        if (checkbox) {
            ActionCheckBox.setImageResource(R.drawable.ic_selected);
        } else {
            ActionCheckBox.setImageResource(R.drawable.ic_unselected);
        }

    }

    public void ChangeForm( ActionPart actionPart) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("ActionPart", actionPart);
        bundle.putInt("Position", getLayoutPosition());
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_action_to_navigation_action_part, bundle);

            }
        });
    }


}

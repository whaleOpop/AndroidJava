package com.android.java.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ActionPart implements Serializable {
    private String Name;
    private String ShortDesp;
    private String ImageUrl;
    private Boolean CheckBox;

    ArrayList<ActionList> ActionLists = new ArrayList<>();

    public ActionPart(String name, String shortDesp, String imageUrl, Boolean checkBox, ArrayList<ActionList> actionLists) {
        Name = name;
        ShortDesp = shortDesp;
        ImageUrl = imageUrl;
        CheckBox = checkBox;
        ActionLists = actionLists;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getShortDesp() {
        return ShortDesp;
    }

    public void setShortDesp(String shortDesp) {
        ShortDesp = shortDesp;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public Boolean getCheckBox() {
        return CheckBox;
    }

    public void setCheckBox(Boolean checkBox) {
        CheckBox = checkBox;
    }

    public ArrayList<ActionList> getActionLists() {
        return ActionLists;
    }

    public void setActionLists(ArrayList<ActionList> actionLists) {
        ActionLists = actionLists;
    }
}

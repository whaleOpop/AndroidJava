package com.android.java.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Action implements Serializable {
    private String ActionDescription;
    private String ActionUrlImage;
    private String ActionActionStatus;
    private ArrayList<ActionPart> actionParts = new ArrayList<ActionPart>();

    public Action(String actionDescription, String actionUrlImage, String actionActionStatus, ArrayList<ActionPart> actionParts) {
        ActionDescription = actionDescription;
        ActionUrlImage = actionUrlImage;
        ActionActionStatus = actionActionStatus;
        this.actionParts = actionParts;
    }

    public String getActionDescription() {
        return ActionDescription;
    }

    public void setActionDescription(String actionDescription) {
        ActionDescription = actionDescription;
    }

    public String getActionUrlImage() {
        return ActionUrlImage;
    }

    public void setActionUrlImage(String actionUrlImage) {
        ActionUrlImage = actionUrlImage;
    }

    public String getActionActionStatus() {
        return ActionActionStatus;
    }

    public void setActionActionStatus(String actionActionStatus) {
        ActionActionStatus = actionActionStatus;
    }

    public ArrayList<ActionPart> getActionParts() {
        return actionParts;
    }

    public void setActionParts(ArrayList<ActionPart> actionParts) {
        this.actionParts = actionParts;
    }
}

package com.android.java.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ActionList implements Serializable {


    private String actionItemDescription;
    private String  actionItemName;
    private String  actionItemstatus;

    private String actionImageUrl;

    public ActionList(String actionItemDescription, String actionItemName, String actionItemstatus, String actionImageUrl) {
        this.actionItemDescription = actionItemDescription;
        this.actionItemName = actionItemName;
        this.actionItemstatus = actionItemstatus;
        this.actionImageUrl = actionImageUrl;
    }

    public String getActionItemDescription() {
        return actionItemDescription;
    }

    public void setActionItemDescription(String actionItemDescription) {
        this.actionItemDescription = actionItemDescription;
    }

    public String getActionItemName() {
        return actionItemName;
    }

    public void setActionItemName(String actionItemName) {
        this.actionItemName = actionItemName;
    }

    public String getActionItemstatus() {
        return actionItemstatus;
    }

    public void setActionItemstatus(String actionItemstatus) {
        this.actionItemstatus = actionItemstatus;
    }

    public String getActionImageUrl() {
        return actionImageUrl;
    }

    public void setActionImageUrl(String actionImageUrl) {
        this.actionImageUrl = actionImageUrl;
    }
}


package com.android.java.saveload;

import android.content.Context;

import com.android.java.entity.Action;
import com.android.java.entity.ActionList;
import com.android.java.entity.ActionPart;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAction {


    public void resetAction(Context context, Action action) {
        File file = new File(context.getFilesDir(), "Actions.json");
        Gson gson = new Gson();
        String json = gson.toJson(action);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAction(Context context, Action action) {
        File file = new File(context.getFilesDir(), "Actions.json");
        Gson gson = new Gson();
        String json = gson.toJson(action);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void saveActionList(Context context, Action action, ActionList actionList) {

        for (int i = 0; i < action.getActionParts().size(); i++) {
            for (int j = 0; j < action.getActionParts().get(i).getActionLists().size(); j++) {
                if (action.getActionParts().get(i).getActionLists().get(j).equals(actionList)) {
                    action.getActionParts().get(i).getActionLists().set(j, actionList);
                }
            }
        }

        saveAction(context, action);
    }


    public void saveActionPart(Context context,Action action, ActionPart actionPart) {
        Load load = new Load();

        for (int i = 0; i < action.getActionParts().size(); i++) {
            if (action.getActionParts().get(i).equals(actionPart)) {
                action.getActionParts().set(i, actionPart);
            }
        }

        saveAction(context, action);
    }


}

package com.android.java.saveload;

import android.content.Context;

import com.android.java.entity.Action;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Load {


    public Action read(Context context) {

        FileInputStream fis = null;

        try {
            fis = context.openFileInput("Actions.json");
        } catch (FileNotFoundException e) {
            return readReset(context);
        }
        InputStreamReader isr = new InputStreamReader(fis);

        BufferedReader bufferedReader = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        String line;
        while (true) {
            try {
                if (!((line = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sb.append(line);
        }

        String jsons = sb.toString();
        Gson gson = new Gson();
        return gson.fromJson(jsons, Action.class);


    }

    public Action readReset(Context context) {

        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(context.getAssets().open("Actions.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bufferedReader = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        String line;
        while (true) {
            try {
                if (!((line = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sb.append(line);
        }

        String jsons = sb.toString();
        Gson gson = new Gson();
        return gson.fromJson(jsons, Action.class);


    }


}

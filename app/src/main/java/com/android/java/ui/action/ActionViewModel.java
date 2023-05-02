package com.android.java.ui.action;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ActionViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ActionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Вы не выбрали задачу");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
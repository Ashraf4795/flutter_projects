package com.example.fragmentcommunicationthroughviewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends ViewModel {


    private final MutableLiveData<Character>typedData = new MutableLiveData<>();

    public void typed(char typedCharacter){
        typedData.setValue(typedCharacter);
    }

    public LiveData<Character> getTypedData(){
        return typedData;
    }



}

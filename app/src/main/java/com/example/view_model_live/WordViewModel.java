package com.example.view_model_live;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class WordViewModel extends AndroidViewModel {

    //Add a private member variable to hold a reference to the Repository.
    private WordRepository mRepository;

    //Add a private LiveData member variable to cache the list of words.
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getmAllWord();
    }

    //Add a "getter" method that gets all the words. This completely hides the implementation from the UI.
    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    //Create a wrapper insert() method that calls the Repository's insert() method.
    // In this way, the implementation of insert() is completely hidden from the UI.
    public void insert(Word word) {
        mRepository.insert(word);
    }
}

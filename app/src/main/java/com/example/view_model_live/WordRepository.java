package com.example.view_model_live;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWord;

    //Add a constructor that gets a handle to the database and initializes the member variables.
    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDataBase(application);
        mWordDao = db.wordDao();
        mAllWord = mWordDao.getAllWords();
    }
//Add a wrapper method called getAllWords() that returns the cached words as LiveData.
    LiveData<List<Word>> getmAllWord() {
        return mAllWord;
    }

    public void insert(Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void>
    {
        private WordDao mAsyncTaskDao;

        public insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}

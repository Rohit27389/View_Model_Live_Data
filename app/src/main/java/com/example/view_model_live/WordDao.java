package com.example.view_model_live;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE from word_table")
    void deleteAll();

    //the WordDao interface, change the getAllWords() method signature so that the returned List<Word>
    // is wrapped with LiveData<>.
    @Query("SELECt * from word_table ORDER by word ASC")
    LiveData<List<Word>> getAllWords();
}

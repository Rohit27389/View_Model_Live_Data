package com.example.view_model_live;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private List<Word> mWord;

    public WordListAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=mLayoutInflater.inflate(R.layout.recyclerview_main,parent,false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
       if(mWord!=null){
           Word current=mWord.get(position);
           holder.wordItemView.setText(current.getWord());
       }else {
           holder.wordItemView.setText("No Word");
       }
    }

    void setWords(List<Word> words){
       mWord=words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mWord != null)
            return mWord.size();
        else return 0;
    }


    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }
}

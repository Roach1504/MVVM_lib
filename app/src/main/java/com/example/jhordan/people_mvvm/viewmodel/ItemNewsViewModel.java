package com.example.jhordan.people_mvvm.viewmodel;


import android.content.Context;
import android.databinding.BaseObservable;
import android.util.Log;

import com.example.jhordan.people_mvvm.model.news.News;

public class ItemNewsViewModel extends BaseObservable{
    private News news;
    private Context context;

    public ItemNewsViewModel(News news, Context context){
        this.news = news;
        this.context = context;
    }

    public String getTitle(){
        return news.getTitle();
    }
    public String getShort(){
        return news.getShort();
    }
    public String getImag(){
        return "http://9834436605.myjino.ru/"+news.getImages().get(0);
    }
    public String getDate(){
        return news.getDate();
    }
    public void OnItemClick(){
        Log.e("Click", "new");
        // TODO: 25.10.2017 replase frame on Item Fragment
    }
}

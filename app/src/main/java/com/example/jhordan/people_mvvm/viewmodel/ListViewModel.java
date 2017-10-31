package com.example.jhordan.people_mvvm.viewmodel;

import android.content.Context;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.example.jhordan.people_mvvm.ApiApplication;
import com.example.jhordan.people_mvvm.data.ApiService;
import com.example.jhordan.people_mvvm.model.news.News;
import com.example.jhordan.people_mvvm.model.news.NewsModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public class ListViewModel extends Observable {
    public ObservableInt newsProgress;
    public ObservableInt newsRecycler;

    private List<News> newsList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ListViewModel(@NonNull Context context){
        this.context = context;
        this.newsList = new ArrayList<>();
        this.newsProgress = new ObservableInt(View.GONE);
        this.newsRecycler = new ObservableInt(View.GONE);
    }

    public void fetchNews(int offset){
        ApiApplication apiApplication = ApiApplication.create(context);
        ApiService apiService = apiApplication.getApiService();
        Disposable disposable = apiService.getNews("20",offset,"1")
                .subscribeOn(apiApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NewsModel>() {
                    @Override
                    public void accept(NewsModel newsModel) throws Exception {
                        Log.e("respons", "true");
                        if(newsModel != null) {
                            Log.e("respons", "news count: " + newsModel.getNews().size());
                            changeNewsDataSet(newsModel.getNews());
                        }
                        else{
                            Log.e("respons", "error");
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("respons", "false");

                    }
                });
        compositeDisposable.add(disposable);
    }

    private void changeNewsDataSet(List<News> news) {
        newsList.addAll(news);
        setChanged();
        notifyObservers();
    }

    public void reset() {
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }

    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}

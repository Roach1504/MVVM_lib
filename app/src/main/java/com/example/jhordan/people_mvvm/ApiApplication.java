package com.example.jhordan.people_mvvm;


import android.app.Application;
import android.content.Context;

import com.example.jhordan.people_mvvm.data.ApiFactory;
import com.example.jhordan.people_mvvm.data.ApiService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class ApiApplication extends Application {
    private ApiService apiService;
    private Scheduler scheduler;

    private static ApiApplication get(Context context) {
        return (ApiApplication) context.getApplicationContext();
    }

    public static ApiApplication create(Context context) {
        return ApiApplication.get(context);
    }

    public ApiService getApiService() {
        if (apiService == null) {
            apiService = ApiFactory.create();
        }
        return apiService;
    }

    public Scheduler subscribeScheduler() {
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }
        return scheduler;
    }

    public void setPeopleService(ApiService apiService) {
        this.apiService = apiService;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}

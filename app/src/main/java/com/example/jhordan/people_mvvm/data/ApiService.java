package com.example.jhordan.people_mvvm.data;


import com.example.jhordan.people_mvvm.model.news.NewsModel;



import retrofit2.http.GET;
import retrofit2.http.Query;
import io.reactivex.Observable;

public interface ApiService {
    @GET("api/get-posts")
    Observable<NewsModel> getNews(@Query("limit") String limit,
                                  @Query("offset") int offset,
                                  @Query("user_id") String user_id);
}

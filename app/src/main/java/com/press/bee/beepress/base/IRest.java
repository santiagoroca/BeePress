package com.press.bee.beepress.base;

import com.press.bee.beepress.Class.Post;
import com.press.bee.beepress.Class.Request;
import com.press.bee.beepress.Class.User;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface IRest {

    @GET("/post/close.php")
    void getClosePosts (Callback<List<Post>> cBack);

    @GET("/post/{id}")
    void getPost (@Path("id") int id, Callback<Post> cBack);

    @POST("/auth")
    void logIn (@Field("username") String username, @Field("password") String password, Callback <Request> cBack);

}

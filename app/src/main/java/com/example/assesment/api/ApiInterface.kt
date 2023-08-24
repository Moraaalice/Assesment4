package com.example.assesment.api
import com.example.assesment.model.Posts
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun getTitle(): Call<List<Posts>>
}
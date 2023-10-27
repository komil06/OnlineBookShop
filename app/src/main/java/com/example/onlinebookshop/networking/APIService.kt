package com.example.onlinebookshop.networking

import com.example.onlinebookshop.model.*
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.http.*
import java.util.logging.Filter

interface APIService {

    @POST("http://handybook.uz/book-api/ register")
    fun register(@Body user: User):Call<UserToken>

    @POST("/book-api/login")
    fun login(@Body login: Login):Call<UserToken>

    @POST("http://handybook.uz/book-api/main-book")
    fun book(@Body book:Book)

    @POST("http://handybook.uz/book-api/all-category")
    fun bookAllCategory(@Body category: Category)

    @GET("http://handybook.uz/book-api/category?")
    fun filterByCategory(@Body filter: Filter)

    @GET("http://handybook.uz/book-api/comment?id=2")
    fun bookByComment(@Body book: Book)

    @POST("http://handybook.uz/comment-api/create")
    fun commentToBook(@Body comment: Comment)

    @GET("http://handybook.uz/book-api/search-name?name=yulduz")
    fun searchBookByName(@Body search: Search)

}
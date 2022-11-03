package com.example.edittext

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//ExampleResponse.kt
data class User(
    @SerializedName("userId")
    val userId: Int,

    @SerializedName("id")
    val id: String,

    @SerializedName("body")
    val body: String

    // @SerializedName으로 일치시켜 주지않을 경우엔 클래스 변수명이 일치해야함
    // @SerializedName()로 변수명을 입치시켜주면 클래스 변수명이 달라도 알아서 매핑
)

//RetorifitService.kt
interface RetrofitService {

    //GET 예제
    @GET("posts/1")
    fun getUser(): Call<User>

    @GET("posts/{page}")
    fun getUserPage(@Path("page") page: String): Call<User>


//    @GET("posts/1")
//    fun getStudent(@Query("school_id") schoolId: Int,
//                   @Query("grade") grade: Int,
//                   @Query("classroom") classroom: Int): Call<ExampleResponse>
//
//
//    //POST 예제
//    @FormUrlEncoded
//    @POST("posts")
//    fun getContactsObject(@Field("idx") idx: String): Call<JsonObject>
}
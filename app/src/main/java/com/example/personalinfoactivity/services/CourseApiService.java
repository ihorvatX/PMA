package com.example.personalinfoactivity.services;

import com.example.personalinfoactivity.apiModels.Courses;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CourseApiService {
    @GET("/v1/courses")
    Call<Courses> getCourses();
}

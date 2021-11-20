package com.example.personalinfoactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.personalinfoactivity.adapter.StudentAdapter;
import com.example.personalinfoactivity.models.Storage;
import com.example.personalinfoactivity.models.Student;

import java.util.List;

public class HomeActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        mRecyclerView = (RecyclerView) findViewById(R.id.RecicleViewData);

        Storage StorageSingleton = Storage.getInstance();
        List<Object> data = StorageSingleton.getStudents();

        if(data.size() == 0)
        {
            data.add("Studenti");
        }

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new StudentAdapter(data);
        mRecyclerView.setAdapter(mAdapter);
    }


    public void OpenPersonalActivity(View view)
    {
        Intent OtvoriPersonalInfo = new Intent(getApplicationContext(), PersonalInfoActivity.class);
        startActivity(OtvoriPersonalInfo);
    }
}
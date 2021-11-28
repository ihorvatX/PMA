package com.example.personalinfoactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.personalinfoactivity.adapter.StudentAdapter;
import com.example.personalinfoactivity.models.Storage;

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
        List<Object> data = StorageSingleton.getDataList();

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
       Intent i = new Intent(getApplicationContext(), CreateNewRecordActivity.class);
        startActivity(i);
    }
}
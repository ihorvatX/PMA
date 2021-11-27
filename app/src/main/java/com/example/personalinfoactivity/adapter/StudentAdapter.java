package com.example.personalinfoactivity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalinfoactivity.R;
import com.example.personalinfoactivity.models.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    final int STUDENT = -1;
    final int HEADER = -2;
    List<Object> dataList;

    public StudentAdapter(List<Object> myDataset) {
        dataList = myDataset;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if(viewType == STUDENT)
        {
            View view = (View) LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.student_info, viewGroup, false);
            return new StudentViewHolder(view);
        }
        else
        {
            View view = (View) LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.header_info, viewGroup, false);
            return new HeaderViewHolder(view);
        }

    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if(getItemViewType(position) == STUDENT)
        {
            StudentViewHolder studentViewHolder = (StudentViewHolder) viewHolder;
            Student data = (Student) dataList.get(position);
            studentViewHolder.tvName.setText((data).getIme());
            studentViewHolder.tvSurname.setText(((Student) dataList.get(position)).getPrezime());
            studentViewHolder.tvCourse.setText(((Student) dataList.get(position)).getPredmet());
        }
        else
        {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) viewHolder;
            headerViewHolder.tvTitle.setText(dataList.get(position).toString());
        }
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
    @Override
    public int getItemViewType(int position) {
        if( dataList.get(position) instanceof Student )
        {
            return STUDENT;
        }
        else
        {
            return HEADER;
        }
    }


    static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvSurname;
        TextView tvCourse;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvSurname = itemView.findViewById(R.id.tvSurname);
            tvCourse = itemView.findViewById(R.id.tvCourse);
        }
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}

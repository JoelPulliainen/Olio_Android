package com.example.viikko9;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    ArrayList<String> Titles;
    ArrayList<String> Times;
    ArrayList<String> Areas;

    public RecyclerAdapter(ArrayList<String> Titles, ArrayList<String> Times, ArrayList<String> Areas) {
        this.Titles = Titles;
        this.Times = Times;
        this.Areas = Areas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.movie_title_text.setText(Titles.get(position));
        holder.movie_time_text.setText(Times.get(position));
        holder.movie_area_text.setText(Areas.get(position));

    }

    @Override
    public int getItemCount() {
        return Titles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView movie_title_text, movie_time_text, movie_area_text;
        public MyViewHolder(View itemView) {
            super(itemView);
            movie_title_text = (TextView)itemView.findViewById(R.id.textView_Title);
            movie_time_text = (TextView)itemView.findViewById(R.id.textView_Time);
            movie_area_text = (TextView)itemView.findViewById(R.id.textView_Area);
        }
    }
}
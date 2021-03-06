package com.example.groupdisscussion.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groupdisscussion.R;
import com.example.groupdisscussion.modalClass.Topic;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class recycler_adapter_category extends RecyclerView.Adapter<recycler_adapter_category.viewHolder> {
    ArrayList<Topic> topicArrayList;
    public recycler_adapter_category(ArrayList<Topic> topicArrayList) {
        this.topicArrayList = topicArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_recycler_view_layout,parent,false);

        return new viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull recycler_adapter_category.viewHolder holder, int position) {
        holder.b_category.setText(topicArrayList.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return topicArrayList.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{
    Button b_category;
        public viewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            b_category = itemView.findViewById(R.id.category);
        }
    }
}

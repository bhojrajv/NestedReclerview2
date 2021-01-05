package com.example.amazonprime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HorizontalAddapter extends RecyclerView.Adapter<HorizontalAddapter.Viewholder> {
    private Context context;
    private ArrayList<HorzontalModel>horizontalAddapters;
    public HorizontalAddapter(Context context, ArrayList<HorzontalModel> horzontalModels) {
        this.context=context;
        this.horizontalAddapters=horzontalModels;

    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=(LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.nested_layout,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        HorzontalModel horzontalModel= horizontalAddapters.get(position);
        holder.imageView.setImageResource(horzontalModel.getImg());
    }



    @Override
    public int getItemCount() {
        return horizontalAddapters.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img);
        }
    }
}

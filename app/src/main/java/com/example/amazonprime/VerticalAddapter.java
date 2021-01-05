package com.example.amazonprime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class VerticalAddapter extends RecyclerView.Adapter<VerticalAddapter.Viewholder> {

    private Context context;
    private ArrayList<Verticalmodel>verticalmodelArrayList;
    private CarouselView carouselView;
    ArrayList<HorzontalModel>singltimes;
    public VerticalAddapter(FragmentActivity activity, ArrayList<Verticalmodel> verticalmodelArrayList) {
        this.context=activity;
        this.verticalmodelArrayList=verticalmodelArrayList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=(LayoutInflater)context
                           .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.hori_layou,parent,false);


        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
         Verticalmodel verticalmodel=verticalmodelArrayList.get(position);
        String titile= verticalmodel.getTitle();
        holder.titleview.setText(titile);
        singltimes=new ArrayList<HorzontalModel>();
        singltimes=verticalmodel.getHorzontalModels();
        HorizontalAddapter horizontalAddapter=new  HorizontalAddapter(context,singltimes);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        holder.recyclerView.setAdapter(horizontalAddapter);




    }



    @Override
    public int getItemCount() {
        return verticalmodelArrayList.size();
    }



    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView titleview;
        private RecyclerView recyclerView;
       private CarouselView carouselView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            titleview=itemView.findViewById(R.id.titleview);
            recyclerView=itemView.findViewById(R.id.nestedRec);
        }

    }
}

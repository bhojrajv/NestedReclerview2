package com.example.amazonprime;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;


public class homefrg extends Fragment {
    int[]sampleimgs=new int []{R.drawable.movie,R.drawable.movie2,R.drawable.movie3,
            R.drawable.movie4,R.drawable.movie5,R.drawable.movie6,R.drawable.movie7};
    ImageListener imageListener;
    private RecyclerView recyclerView;
    private VerticalAddapter verticalAddapter;
 private CarouselView carouselView;
 private Context context;
 private ArrayList<Verticalmodel>verticalmodelArrayList;
private ArrayList<Integer> arrayList;
private ArrayList<Boolean>integerArrayList;
private ArrayList<HorzontalModel>horzontalModelslist;
    public homefrg() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        LayoutInflater layoutInflater=(LayoutInflater) getActivity().
//                                 getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.fragment_homefrg, container, false);
        carouselView= view.findViewById(R.id.carouselView);
        recyclerView=view.findViewById(R.id.recyclerview);
        integerArrayList=new ArrayList<>();
        horzontalModelslist=new ArrayList<>();
       arrayList=new ArrayList<>();
        verticalmodelArrayList=new ArrayList<>();
        verticalAddapter=new VerticalAddapter(getActivity(),verticalmodelArrayList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(verticalAddapter);

        carouselView.setPageCount(sampleimgs.length);
        imageListener=new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleimgs[position]);
            }
        };
     carouselView.setImageListener(imageListener);


        // Inflate the layout for this fragment
        for (int i=1;i<=10;i++){
            Verticalmodel verticalmodel=new Verticalmodel();
            verticalmodel.setTitle("Title"+i);
            verticalmodelArrayList.add(verticalmodel);

            for(int j=0;j<5;j++){
                HorzontalModel horzontalModel=new HorzontalModel();
                horzontalModel.setImg(R.drawable.movie+i);

                horzontalModelslist.add(horzontalModel);


            }
//            arrayList.add(R.drawable.movie6);
//            arrayList.add(R.drawable.movie2);
//            arrayList.add(R.drawable.movie3);
//            arrayList.add(R.drawable.movie4);
//            arrayList.add(R.drawable.movie5);
//            arrayList.add(R.drawable.movie6);
           // verticalmodel.setHorzontalModels(arrayList);
            verticalmodel.setHorzontalModels(horzontalModelslist);

        }
        verticalAddapter.notifyDataSetChanged();

        return view;

    }

}
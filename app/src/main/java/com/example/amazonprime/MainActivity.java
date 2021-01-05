package com.example.amazonprime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.FrameMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
private Toolbar toolbar;
private TabLayout tabLayout;
private ViewPager pager;
private FrgamenAddapter frgamenAddapter;
private BottomNavigationView bottomNavigationView;
private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        tabLayout=findViewById(R.id.tablayout);
        frameLayout=findViewById(R.id.container);
        bottomNavigationView=findViewById(R.id.bottomnav);
        frgamenAddapter=new FrgamenAddapter(getSupportFragmentManager());
        pager=findViewById(R.id.viewpager);
        getSupportActionBar();
        pager.setAdapter(frgamenAddapter);
        tabLayout.setupWithViewPager(pager);
       pager.setVisibility(View.GONE);

      tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
          @Override
          public void onTabSelected(TabLayout.Tab tab) {
           switch (tab.getPosition()){
               case 0:
                   pager.setVisibility(View.VISIBLE);
                   frameLayout.setVisibility(View.GONE);
               case 1:
                   pager.setVisibility(View.VISIBLE);
                   frameLayout.setVisibility(View.GONE);
               case 2:
                   pager.setVisibility(View.VISIBLE);
                   frameLayout.setVisibility(View.GONE);
               case 3:
                   pager.setVisibility(View.VISIBLE);
                   frameLayout.setVisibility(View.GONE);
           }
          }

          @Override
          public void onTabUnselected(TabLayout.Tab tab) {

          }

          @Override
          public void onTabReselected(TabLayout.Tab tab) {
              pager.setVisibility(View.VISIBLE);

          }
      });
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        pager.setVisibility(View.GONE);
                        frameLayout.setVisibility(View.VISIBLE);
                        homefrg homefrg=new homefrg();
                        FragmentManager manager=getSupportFragmentManager();
                        FragmentTransaction transaction=manager.beginTransaction();
                        transaction.replace(R.id.container,homefrg);
                        transaction.commit();
                          break;
                    case R.id.find:
                        frameLayout.setVisibility(View.VISIBLE);
                        pager.setVisibility(View.GONE);
                        findfrg findfrg=new findfrg();
                        FragmentManager manager1=getSupportFragmentManager();
                        FragmentTransaction transaction1=manager1.beginTransaction();
                        transaction1.replace(R.id.container,findfrg);
                        transaction1.commit();
                        break;
                    case R.id.download:
                        pager.setVisibility(View.GONE);
                        frameLayout.setVisibility(View.VISIBLE);
                        downloadfrg downloadfrg=new downloadfrg();
                        FragmentManager fragmentManager=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container,downloadfrg);
                        fragmentTransaction.commit();
                     break;
                    case R.id.profile:
                        pager.setVisibility(View.GONE);
                        frameLayout.setVisibility(View.VISIBLE);
                        Mystuff mystuff=new Mystuff();
                        FragmentManager fragmentManager1=getSupportFragmentManager();
                        FragmentTransaction transaction2=fragmentManager1.beginTransaction();
                        transaction2.replace(R.id.container,mystuff);
                        transaction2.commit();
                    default:

                        pager.setVisibility(View.GONE);
                        frameLayout.setVisibility(View.VISIBLE);
                        homefrg homefrg3=new homefrg();
                        FragmentManager manager3=getSupportFragmentManager();
                        FragmentTransaction transaction3=manager3.beginTransaction();
                        transaction3.replace(R.id.container,homefrg3);
                        transaction3.commit();
                }
            }
        });

    }

}
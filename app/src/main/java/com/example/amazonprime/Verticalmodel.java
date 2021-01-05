package com.example.amazonprime;

import java.util.ArrayList;

public class Verticalmodel {
    ArrayList<HorzontalModel>horzontalModels;
    String title;

    public ArrayList<HorzontalModel> getHorzontalModels() {
        return horzontalModels;
    }

    public void setHorzontalModels(ArrayList<HorzontalModel> horzontalModels) {
        this.horzontalModels = horzontalModels;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

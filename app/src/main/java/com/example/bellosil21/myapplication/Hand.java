package com.example.bellosil21.myapplication;

import java.io.Serializable;
import java.util.ArrayList;

public class Hand implements Serializable{
    Card hole1;
    Card hole2;

    public Hand(Card hole1, Card hole2){
        this.hole1 = hole1;
        this.hole2 = hole2;
    }
}

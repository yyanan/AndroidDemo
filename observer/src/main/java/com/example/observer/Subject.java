package com.example.observer;


import android.arch.lifecycle.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers
            = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(BinaryObserver observer){
        //observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            //observer.update();
        }
    }
}

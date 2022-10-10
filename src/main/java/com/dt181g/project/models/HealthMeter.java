package com.dt181g.project.models;

import java.util.ArrayList;
import java.util.List;

public class HealthMeter implements Observable {

    public static final HealthMeter INSTANCE = new HealthMeter();
    public List<Observer> observers = new ArrayList<>();
    public int health = 50;

    public HealthMeter() {}

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);

    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    public synchronized void addHealth(int healAmount) {
        health = health + healAmount;
        notifyObservers();
    }

    public synchronized void removeHealth(int damageAmount) {
        health = health - damageAmount;
        notifyObservers();
    }

    public synchronized int getHealth() {
        return health;
    }
}

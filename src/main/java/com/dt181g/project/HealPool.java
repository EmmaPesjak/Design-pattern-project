package com.dt181g.project;

import java.util.ArrayList;
import java.util.List;

public class HealPool implements Observable {

    public static final HealPool INSTANCE = new HealPool();
    public List<Observer> observers = new ArrayList<>();
    public int health = 50;

    public HealPool() {}

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
        System.out.println("health is: " + getHealth());
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

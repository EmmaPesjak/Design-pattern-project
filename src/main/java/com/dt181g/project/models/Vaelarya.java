package com.dt181g.project.models;

import com.dt181g.project.controllers.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Observable class that represents the amount of health of the dragon Vaelarya,
 * communicating directly with the actors, implemented as a Singleton.
 * @author Emma Pesjak
 */
public class Vaelarya implements Observable {
    public static final Vaelarya INSTANCE = new Vaelarya();
    public List<Observer> observers = new ArrayList<>();
    public int health = 50;

    /**
     * Private constructor.
     */
    private Vaelarya() {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    /**
     * Method used by the HealThread to add health to Vaelarya, and to notify observers.
     * @param healAmount is the amount of health added.
     */
    public synchronized void addHealth(int healAmount) {
        health = health + healAmount;
        notifyObservers();
    }

    /**
     * Method used by DamageThreads to remove health from Vaelarya, and to notify observers.
     * @param damageAmount is the amount of health removed.
     */
    public synchronized void removeHealth(int damageAmount) {
        health = health - damageAmount;
        notifyObservers();
    }

    /**
     * Accessor for the current health.
     * @return the current health.
     */
    public synchronized int getHealth() {
        return health;
    }
}
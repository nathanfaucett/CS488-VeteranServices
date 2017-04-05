package edu.jsu.veteran_services;


import java.util.*;


public class State {
    private static State globalState;

    public String currentView;
    public Map<String, String> params;
    public Set<Runnable> listeners;


    public State() {
        currentView = "students";
        params = new HashMap<>();
        listeners = new HashSet<>();
    }

    public static State get() {
        if (globalState == null) {
            globalState = new State();
        }
        return globalState;
    }

    public State addListener(Runnable listener) {
        listeners.add(listener);
        return this;
    }
    public State removeListener(Runnable listener) {
        listeners.remove(listener);
        return this;
    }

    public State update() {
        for (Runnable runnable: listeners) {
            runnable.run();
        }
        return this;
    }
}

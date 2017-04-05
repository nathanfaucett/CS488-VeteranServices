package edu.jsu.veteran_services;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class View extends JFrame {


    public View() {
        super("Veteran Services");

        setSize(960, 640);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final View _this = this;
        State.get().addListener(new Runnable() {
            @Override
            public void run() {
                _this.render();
            }
        });

        render();

        setVisible(true);
    }

    public void clear() {
        getContentPane().removeAll();
    }

    public void render() {
        clear();

        JScrollPane scroll = new JScrollPane();
        State state = State.get();

        switch (state.currentView) {
            case "students":
                scroll.setViewportView(new StudentsView());
                break;
            case "student_show":
                scroll.setViewportView(new StudentShow(state.params.get("studentid")));
                break;
        }

        add(scroll);

        validate();
    }
}

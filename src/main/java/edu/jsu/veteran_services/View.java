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

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(new StudentView());
        add(scroll);

        setVisible(true);
    }
}

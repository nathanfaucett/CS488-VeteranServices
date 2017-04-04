package edu.jsu.veteran_services;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class StudentView extends JPanel {


    public StudentView(Sql sql) {
        Students students = new Students(sql);
        java.util.List<Student> studentList = students.all();

        for (Student student: studentList) {
            add(new StudentInfoView(student));
        }
    }

    public class StudentInfoView extends JPanel {

        public StudentInfoView(Student student) {
            JLabel id = new JLabel();
            id.setName("Id");
            JLabel name = new JLabel();
            name.setName("Name");
            JLabel email = new JLabel();
            email.setName("Email");

            GridLayout grid = new GridLayout(0,1);
            grid.setHgap(20);
            this.setLayout(grid);

            add(id);
            add(name);
            add(email);
        }
    }
}

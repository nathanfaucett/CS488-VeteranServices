package edu.jsu.veteran_services;


import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class StudentShow extends JPanel {
    private String studentid;


    public StudentShow(String studentid) {
        this.studentid = studentid;
        render();
    }

    public void clear() {
        removeAll();
    }

    public void render() {
        clear();

        Students students = new Students(Sql.get());
        Student student = students.show(studentid);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JButton button = new JButton("Back");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                State state = State.get();
                state.currentView = "students";
                state.params.remove("studentid");
                state.update();
            }
        });
        add(button);
        add(new StudentInfo(student));
    }

    public static class StudentInfo extends JPanel {

        public StudentInfo(Student student) {
            setLayout(new GridLayout(0, 3));

            add(new JLabel("Id: " + student.studentid));
            add(new JLabel("Name: " + student.firstname + " " + student.lastname));
            add(new JLabel("SSN: " + student.ssn));
            add(new JLabel("Email: " + student.email));
            add(new JLabel("Street: " + student.street));
            add(new JLabel("City: " + student.city));
            add(new JLabel("State: " + student.state));
            add(new JLabel("Zipcode: " + student.zipcode));
            add(new JLabel("GPA: " + student.gpa));
            add(new JLabel("Hours Enrolled: " + student.hoursenrolled));
            add(new JLabel("Repeating: " + Utils.intToBool(student.repeating)));
            add(new JLabel("Major: " + student.major));
            add(new JLabel("Tuition and Fees: $" + student.tuitionandfees));
            add(new JLabel("Veteran Benefits: " + Utils.intToBool(student.veteranbenefits)));
            add(new JLabel("Dependent Benefits: " + Utils.intToBool(student.dependentbenefits)));
            add(new JLabel("Disability Benefirts: " + Utils.intToBool(student.disabilitybenefirts)));
        }
    }
}

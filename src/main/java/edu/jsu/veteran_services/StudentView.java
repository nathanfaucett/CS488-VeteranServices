package edu.jsu.veteran_services;


import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class StudentView extends JPanel {


    public StudentView() {
        render();
    }

    public void clear() {
        removeAll();
    }

    public void render() {
        clear();

        setLayout(new GridLayout(0,1));

        add(new StudentCreateView(this));
        add(new StudentListView());
    }

    public class StudentListView extends JPanel {

        public StudentListView() {
            setLayout(new GridLayout(0,1));

            Students students = new Students(Sql.get());
            java.util.List<Student> studentList = students.all();

            for (Student student: studentList) {
                add(new StudentInfoView(student));
            }
        }
    }
    public class StudentInfoView extends JPanel {

        public StudentInfoView(Student student) {
            add(new JLabel("Id: " + student.studentid));
            add(new JLabel("Name: " + student.firstname + " " + student.lastname));
            add(new JLabel("Email: " + student.email));
        }
    }

    public class StudentCreateView extends JPanel {
        private String[] textFieldNames = {
            "studentid",
            "firstname",
            "lastname",
            "ssn",
            "email",
            "street",
            "city",
            "state",
            "zipcode",
            "major",
            "hoursenrolled",
            "gpa",
            "tuitionandfees"
        };

        private String[] checkboxNames = {
            "repeating",
            "veteranbenefits",
            "dependentbenefits",
            "disabilitybenefirts"
        };

        private Map<String, JTextField> textFields = new HashMap<>();
        private Map<String, JCheckBox> checkboxes = new HashMap<>();

        public StudentCreateView(final StudentView parent) {
            super(new GridLayout(0, 2));

            for (int i = 0; i < textFieldNames.length; i++) {
                JLabel label = new JLabel(textFieldNames[i]);
                add(label);

                JTextField textField = new JTextField(32);
                label.setLabelFor(textField);

                textFields.put(textFieldNames[i], textField);
                add(textField);
            }

            for (int i = 0; i < checkboxNames.length; i++) {
                JLabel label = new JLabel(checkboxNames[i]);
                add(label);

                JCheckBox checkbox = new JCheckBox();
                label.setLabelFor(checkbox);

                checkboxes.put(checkboxNames[i], checkbox);
                add(checkbox);
            }

            JButton button = new JButton("Create Student");
            final StudentCreateView studentCreateView = this;

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Students students = new Students(Sql.get());
                        PreparedStatement ps = students.create();

                        for (int i = 0; i < 9; i++) {
                            ps.setString(1 + i, textFields.get(textFieldNames[i]).getText());
                        }

                        ps.setInt(10, Integer.parseInt(textFields.get("zipcode").getText()));
                        ps.setInt(11, Integer.parseInt(textFields.get("hoursenrolled").getText()));
                        ps.setFloat(12, Float.parseFloat(textFields.get("gpa").getText()));
                        ps.setFloat(13, Float.parseFloat(textFields.get("tuitionandfees").getText()));

                        for (int i = 0; i < checkboxNames.length; i++) {
                            ps.setInt(14 + i, checkboxes.get(checkboxNames[i]).isSelected() ? 1 : 0);
                        }

                        ps.executeUpdate();
                        ps.close();

                        parent.render();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            add(button);
        }
    }
}

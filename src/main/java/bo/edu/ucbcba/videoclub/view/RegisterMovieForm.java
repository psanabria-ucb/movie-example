package bo.edu.ucbcba.videoclub.view;

import bo.edu.ucbcba.videoclub.controller.MovieController;
import bo.edu.ucbcba.videoclub.exceptions.ValidationException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterMovieForm extends JDialog {
    private JPanel rootPanel;
    private JTextField title;
    private JTextArea description;
    private JTextField hoursLength;
    private JTextField minutesLength;
    private JTextField releaseYear;
    private JButton saveButton;
    private JButton cancelButton;
    private JRadioButton rating1;
    private JRadioButton rating2;
    private JRadioButton rating3;
    private JRadioButton rating4;
    private JRadioButton rating5;
    private int rating = 5;
    private MovieController controller;

    RegisterMovieForm(JFrame parent) {
        super(parent, "Register Movie", true);
        setContentPane(rootPanel);
        pack();
        setResizable(false);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveUser();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancel();
            }
        });
        ActionListener ratingListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rating = Integer.parseInt(((JRadioButton)e.getSource()).getText());
            }
        };
        rating1.addActionListener(ratingListener);
        rating2.addActionListener(ratingListener);
        rating3.addActionListener(ratingListener);
        rating4.addActionListener(ratingListener);
        rating5.addActionListener(ratingListener);
        controller = new MovieController();
    }

    private void saveUser() {
        try {
            controller.create(title.getText(),
                    description.getText(),
                    releaseYear.getText(),
                    rating,
                    hoursLength.getText(),
                    minutesLength.getText());
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Format error", JOptionPane.ERROR_MESSAGE);
        }

        JOptionPane.showMessageDialog(this, "Movie created successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        cancel();
    }

    private void cancel() {
        setVisible(false);
        dispose();
    }
}

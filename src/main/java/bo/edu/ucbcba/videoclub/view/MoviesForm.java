package bo.edu.ucbcba.videoclub.view;

import bo.edu.ucbcba.videoclub.controller.MovieController;
import bo.edu.ucbcba.videoclub.model.Movie;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MoviesForm extends JFrame {
    private JPanel rootPanel;
    private JTextField searchText;
    private JButton searchButton;
    private JTable moviesTable;
    private JButton createButton;
    private MovieController movieController;

    public MoviesForm() {
        super("Movies");
        setContentPane(rootPanel);
        setSize(600, 400);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchRegister();
            }
        });
        movieController = new MovieController();
        populateTable();
    }

    private void launchRegister() {
        RegisterMovieForm form = new RegisterMovieForm(this);

        form.setVisible(true);
        populateTable();
    }

    private void populateTable() {
        List<Movie> movies = movieController.getAllMovies();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Title");
        model.addColumn("Description");
        model.addColumn("Rating");
        model.addColumn("Release Year");
        model.addColumn("Length");
        moviesTable.setModel(model);

        for (Movie m : movies) {
            Object[] row = new Object[5];

            row[0] = m.getTitle();
            row[1] = m.getDescription();
            row[2] = m.getRating();
            row[3] = m.getReleaseYear();
            row[4] = String.format("%s:%s", m.getLength() / 60, m.getLength() % 60);
            model.addRow(row);
        }
    }
}

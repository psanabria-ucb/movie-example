package bo.edu.ucbcba.videoclub.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoviesForm extends JFrame {
    private JPanel rootPanel;
    private JTextField searchText;
    private JButton searchButton;
    private JTable moviesTable;
    private JButton createButton;

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
    }

    private void launchRegister() {
        RegisterMovieForm form = new RegisterMovieForm(this);

        form.setVisible(true);
    }
}

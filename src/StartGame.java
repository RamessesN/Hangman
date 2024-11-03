import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartGame extends JFrame {
    // Create a game start interface to inform player the rule of the game
    public StartGame() {
        // Set the size and boundaries
        setBounds(50, 50, 250, 130);
        // Close the window when press the exit button
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Set the title of the game starting window
        setTitle("Game Starting");
        // Set the lay-out
        setLayout(new FlowLayout());
        // Set the window in the center of the screen
        setLocationRelativeTo(null);

        // Set two buttons to ask player whether to play or not
        JButton jb1 = new JButton();
        JButton jb2 = new JButton();
        // Add relative content on the JLabel
        JLabel jl1 = new JLabel("Version 1.2.1\tauthor: Stanley");
        JLabel jl2 = new JLabel("Are you ready?");
        // Add relative content on the JButton
        jb1.setText("Start");
        jb2.setText("Cancel");
        // Make the buttons clickable
        jb1.addActionListener(new jbAction1());
        jb2.addActionListener(new jbAction2());
        // Add labels and buttons on the screen
        add(jb1);
        add(jb2);
        add(jl1);
        add(jl2);
        // Make it visible
        setVisible(true);
    }

    class jbAction1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            // If press start button, then mainWindow window starts
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true); // Make it visible
            dispose(); // When mainWindow starts, dispose the game starting window
        }
    }
    class jbAction2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            // If press cancel button, then exit the program
            System.exit(0);
        }
    }
}
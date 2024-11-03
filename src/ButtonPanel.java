import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel {
    private JButton[] jb = new JButton[26]; // Definite a series of buttons to demonstrate 26 letters in the alphabet
    private WordPanel wordPanel; // Definite a wordPanel item
    private HealthPanel healthPanel; // Definite a healthPanel item
    private MainWindow mainWindow;
    public ButtonPanel(WordPanel wordPanel, HealthPanel healthPanel, MainWindow mainWindow) {
        // Introduce wordPanel and healthPanel into the constructor
        this.wordPanel = wordPanel;
        this.healthPanel = healthPanel;
        this.mainWindow = mainWindow;
        // Set the lay-out of the buttons
        setLayout(new GridLayout(4, 7, 5, 5));
        // Initialize the buttons with A~Z letters
        for(int i = 0; i < 26; i++) {
            char letter = (char) ('A' + i); // Definite the text
            jb[i] = new JButton(String.valueOf(letter)); // Add the text onto the buttons
            jb[i].addActionListener(new jbAction()); // Make the buttons clickable
            add(jb[i]); // Add the buttons to the panel
        }
    }
    class jbAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            JButton button = (JButton) event.getSource();
            char letter = button.getActionCommand().charAt(0); // Get which button player has clicked

            wordPanel.guess(letter, healthPanel, mainWindow); // Run the guess() method in the WordPanel class to change the word panel
            //healthPanel.removeLife(letter); // Run the removeLife() method in the HealthPanel class to change the health panel
            button.setVisible(false); // Make the button invisible
        }
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    // Definite three items - wordPanel, healthPanel and buttonPanel
    private WordPanel wordPanel;
    private HealthPanel healthPanel;
    private ButtonPanel buttonPanel;
    private int counter;
    public MainWindow() { // Definite a constructor to demonstrate the window
        setTitle("Hangman 1.2.1"); // Set the title of the window
        setBounds(100, 100, 900, 700); // Set the bounds of the window
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Make sure if player press click-off button then exit the program
        setLocationRelativeTo(null); // Set the location of the window in the center of the screen
        setLayout(new GridLayout(4, 1, 5, 5)); // Set the lay-out of the three labels
        // Create three according items
        wordPanel = new WordPanel();
        healthPanel = new HealthPanel(wordPanel);
        buttonPanel = new ButtonPanel(wordPanel, healthPanel, this);

        // Add three items on the windows
        add(healthPanel);
        add(buttonPanel);
        add(wordPanel);

        JButton jButton = new JButton("Tip");
        jButton.addActionListener(new jbAction());
        jButton.setFont(new Font("Times New Roman", Font.BOLD ,20));
        jButton.setForeground(Color.RED);
        jButton.setOpaque(true);

        JPanel Holder = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Holder.add(jButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        add(Holder, gbc);
        // Make the window visible
        setVisible(true);
    }
    class jbAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            new TipDialog(wordPanel);
        }
    }
}
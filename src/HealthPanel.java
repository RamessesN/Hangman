import javax.swing.*;
import java.awt.*;
import java.util.*;

public class HealthPanel extends JPanel {
    private JLabel[] jl; /* Create a series of labels to store the length of a random word which
                            was extracted from wordPanel */
    private WordPanel wordPanel; // Introduce a wordPanel
    private String randomWord; // Suppose a randomWord
    private int livesMax, lives, leftLives; // Definite max lives and instance lives and left lives we have
    private Set<Character> set = new HashSet<>(); // Definite a set to store how many kinds of letters in a word
    private MainWindow mainWindow;
    public HealthPanel(WordPanel wordPanel) {
        // Introduce wordPanel and randomWord into constructor
        this.wordPanel = wordPanel;
        this.randomWord = wordPanel.getWord();
        // Add each letter in the word into set Collector
        for(int i = 0; i < randomWord.length(); i++) {
            char letter = randomWord.charAt(i);
            set.add(letter);
        }
        // Introduce livesMax and lives into constructor
        this.livesMax = set.size();
        this.lives = livesMax;
        // Introduce jl into constructor
        jl = new JLabel[livesMax]; // It's used to store living labels (green/red)
        // Set suitable lay-out
        setLayout(new GridLayout(1, jl.length, 5, 5));
        // Set initial JLabel to demonstrate how much lives we have
        for (int i = 0; i < jl.length; i++) {
            jl[i] = new JLabel(String.valueOf(i + 1)); // Add labels to jl
            jl[i].setBackground(Color.GREEN); // Set the background color of jl is green
            jl[i].setFont(new Font("Times New Roman", Font.BOLD, 40)); // Set the font of the content on the label
            jl[i].setOpaque(true); // Make it opaque
            jl[i].setHorizontalAlignment(JLabel.CENTER); // Make the jl locate in the center of the label
            add(jl[i]);   // Add labels to the panel
        }
    }
    // Set a method named removeLife to remove lives when play make faults
    public void removeLife(char letter, MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        boolean isLetterCorrect = false; // Definite a boolean item to judge whether the letter guessed is true
        for (int i = 0; i < randomWord.length(); i++) {
            if (randomWord.charAt(i) == letter) { // If they're equivalent then make the judge true
                isLetterCorrect = true;
                break;
            }
        }

        if (!isLetterCorrect) { // If judge false then update the color of the label and remove lives
            for (int i = jl.length - 1; i >= 0; i--) {
                if (jl[i].getBackground().equals(Color.GREEN)) {
                    jl[i].setBackground(Color.RED);
                    lives--;
                    break;
                }
            }
            if(lives <= 0) { // If instant lives player have is less than 0, then game over.
                new GameOver(this, wordPanel, mainWindow);
            }
        }
    }

    public int getLives() { // Set a method named getLives in order to let other class to use
        for(int i = 0; i < jl.length; i++) {
            if(jl[i].getBackground().equals(Color.GREEN)) { // If the color of each label us green
                leftLives = i + 1; // then update the left lives
            }
        }
        return leftLives;   // Return this item
    }
}
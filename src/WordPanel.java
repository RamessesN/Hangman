import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class WordPanel extends JPanel {
    private final ArrayList<String> wordlist = new ArrayList<>(); // Definite an arrayList to store every word
    private HealthPanel healthPanel; // Definite a healthPanel item
    private String randomWord; // Definite a random word which was extracted from wordPanel
    public JLabel[] jl; // Definite a series of labels to demonstrate the word and _ .
    public MainWindow mainWindow;
    // Set a constructor
    public WordPanel() {
        Path filePath = Paths.get(System.getProperty("user.dir"), "WordList", "wordList.txt");
        // Set a file which we need to extract a random word from
        File file = new File(String.valueOf(filePath));
        // Judge whether the file is existed
        if (file.exists()) {
            System.out.println("File found successfully.");
            try {
                //Read the file
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String tmp = null;
                while ((tmp = bufferedReader.readLine()) != null) {
                    String pureWord = tmp.trim(); // Remove spaces around words to get pure word
                    if (!pureWord.isEmpty()) {
                        wordlist.add(pureWord); // Add the pure word into the word list
                    }
                }
                // Close the InputStream
                bufferedReader.close();
                fileReader.close();
                // Judge whether the wordList is empty
                if (!wordlist.isEmpty()) {
                    // Get random word from the wordList
                    Random random = new Random();
                    int randomIndex = random.nextInt(wordlist.size());
                    randomWord = wordlist.get(randomIndex);
                    System.out.println("The random word is: " + randomWord);
                    jl = new JLabel[randomWord.length()]; // Definite the label which length is equivalent to the length of the random word
                    // Initialize the labels
                    for (int i = 0; i < randomWord.length(); i++) {
                        jl[i] = new JLabel("_"); // Add _ onto the labels
                        jl[i].setFont(new Font("Times New Roman", Font.BOLD, 80)); // Definite the font of the texts on the labels
                        add(jl[i]); //Add the labels onto the panel
                    }
                } else {
                    System.out.println("Nothing in the wordlist."); // If getting random word failed, then give out a tip
                }
            } catch (IOException e) { // Catch exception
                e.printStackTrace();
            }
        } else { // If getting file failed, then give out a tip and exit the program
            System.out.println("File found failed. Please upload your wordList.txt on your desktop.");
            System.exit(0);
        }
    }

    // Definite a method named getWord in order to let other classes to get this random word
    public String getWord() {
        return randomWord;
    }

    // Definite a method named guess in order to judge whether the letter on the button is equivalent to the letter in a word
    public void guess(char letter, HealthPanel healthPanel, MainWindow mainWindow) {
        this.healthPanel = healthPanel; // Introduce healthPanel into this method
        this.mainWindow = mainWindow;
        // Definite a boolean item to judge whether letter player guessed is correct
        boolean isLetterCorrect = false;
        for (int i = 0; i < randomWord.length(); i++) {
            if (randomWord.charAt(i) == letter) { // If equivalent, then change _ into according letter
                jl[i].setFont(new Font("Times New Roman", Font.BOLD, 80));
                jl[i].setText(String.valueOf(letter));
                isLetterCorrect = true;
            }
        }
        if(!isLetterCorrect) {
            healthPanel.removeLife(letter, mainWindow); // If not equivalent, then remove a live
        } else {
            boolean isWordComplete = true;
            for (JLabel label : jl) { // Surf through the whole label to find relative text
                if (label.getText().equals("_")) {
                    isWordComplete = false;
                    break;
                }
            }
            if (isWordComplete && healthPanel.getLives() > 0) {
                new Congratulations(healthPanel, mainWindow); // If word guessed completely and lives player left after guessing, then congratulations
            }
        }
    }
}
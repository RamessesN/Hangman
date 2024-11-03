import javax.swing.*;

public class GameOver extends JDialog {
    private HealthPanel healthPanel; // Definite a healthPanel item
    private WordPanel wordPanel; // Definite a wordPanel item
    private MainWindow mainWindow;
    public GameOver(HealthPanel healthPanel, WordPanel wordPanel, MainWindow mainWindow) {
        // Introduce the healthPanel and wordPanel into the Constructor
        this.healthPanel = healthPanel;
        this.wordPanel = wordPanel;
        this.mainWindow = mainWindow;
        // Definite the message of the dialog when player failed
        String message = "Defeat! You have " + healthPanel.getLives() + " lefts.\n"
                + "The word is: " + wordPanel.getWord();
        // Add according contents onto the dialog
        int choice = JOptionPane.showOptionDialog(null,
                message, "Game Over",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, new String[] {"Quit", "Restart"}, null);
        // Use a choice to judge which one player clicked
        if(choice == JOptionPane.NO_OPTION) {
            reStartGame(mainWindow); // If click Restart, then run reStartGame() method to create a new game
        } else {
            System.exit(0); // If click Quit, then exit the program
        }
    }
    // Definite a method named reStartGame() to create a new game
    public void reStartGame(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        mainWindow.dispose();
        new MainWindow(); // Create a new game
    }
}
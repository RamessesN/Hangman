import javax.swing.*;

public class Congratulations extends JDialog {
    private HealthPanel healthPanel; // Definite a healthPanel item
    private MainWindow mainWindow;
    public Congratulations(HealthPanel healthPanel, MainWindow mainWindow) {
        // Introduce the healthPanel into the Constructor
        this.healthPanel = healthPanel;

        this.mainWindow = mainWindow;
        // Definite the message of the dialog when player succeeds
        String message = "Bingo!\nYou have " + healthPanel.getLives() + " lefts.\n";

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
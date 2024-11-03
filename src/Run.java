import javax.swing.*;
public class Run {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StartGame();
        });
    }
}
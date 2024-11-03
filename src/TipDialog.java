import javax.swing.*;
import java.util.Random;

public class TipDialog extends JDialog {
    private WordPanel wordPanel;
    public TipDialog(WordPanel wordPanel) {
        this.wordPanel = wordPanel;

        setSize(300, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tip");

        Random random = new Random();
        int index = random.nextInt(wordPanel.getWord().length());

        JLabel tip = new JLabel("One letter of the word is: " + wordPanel.getWord().charAt(index));

        tip.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(tip);
        setVisible(true);
    }
}

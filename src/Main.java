import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static BraunAssertions.BraunAssert.*;

public class Main {
    public static void main(String[] args) {
        
        //later function that grabs from file or lets you choose
        String totalText = "das ist der Text";
        
        var frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMaximumSize(new Dimension(800, 600));
        frame.setLayout(new GridLayout(2, 1));
        
        var displayer = new Displayer(totalText);
        var label = new JLabel(displayer.getCurrentText());
        label.setSize(200,100);
        frame.add(label);
        
        var textField = new JTextField();
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
               
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    // trim text in label if word is right
                    String typedWord = textField.getText();
                    bassert(typedWord.endsWith(" "), "no space found");
                    typedWord = typedWord.substring(0,typedWord.length()-1);
                    bassert(!typedWord.endsWith(" "), "space not removed");
                    
                    if (typedWord.equals(displayer.getCurrentWord())) {
                        //trim currenttext by that word
                        displayer.trimFirstWord();

                        //TODO handle last word
                        
                        //update the label
                        label.setText(displayer.getCurrentText());

                        //reset textfield
                        textField.setText(null);
                    }

                }
            }
        });
        
        frame.add(textField);
        
        frame.setVisible(true);
        

    }
}

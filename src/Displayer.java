import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static BraunAssertions.BraunAssert.bassert;

public class Displayer {
    private String currentText;
    private JTextField textField;

    public Displayer(String totalText, JLabel label) {
        setCurrentText(totalText);
        label.setText(totalText);
        
        if (this.textField == null) {
            this.textField = new JTextField();
        }
        
        setTextFieldListeners(label);
    }

    private void setTextFieldListeners(JLabel label) {
        this.textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) { }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    // trim text in label if word is right
                    String typedWord = textField.getText();
                    bassert(typedWord.endsWith(" "), "no space found");
                    typedWord = typedWord.substring(0,typedWord.length()-1);
                    bassert(!typedWord.endsWith(" "), "space not removed");

                    if (typedWord.equals(getCurrentWord())) {
                        //trim currenttext by that word
                        trimFirstWord();

                        //TODO handle last word

                        //update the label
                        if (getCurrentText().isEmpty()) {
                            label.setText("FINISHED");
                        } else {
                            label.setText(getCurrentText());
                        }

                        //reset textfield
                        textField.setText(null);
                    }

                }
            }
        });
    }

    private void setCurrentText(String text) {
       this.currentText = text; 
    }

    public String getCurrentText() {
        return this.currentText;
    }

    public String getCurrentWord() {
        return this.currentText.split(" ")[0];
    }

    public void trimFirstWord() {
        // word
        this.currentText = this.currentText.replaceFirst(this.getCurrentWord(), "");
        // corresponding space after
        this.currentText = this.currentText.replaceFirst(" ", "");
    }

    public JTextField getTextField() {
        return this.textField;
    }
}

import javax.swing.*;

public class Displayer {
    private String currentText;
    
    public Displayer(String totalText) {
        setCurrentText(totalText);
    }
        
    private void setCurrentText(String text) {
       this.currentText = text; 
    }

    public static void test(String a, int b, InputMap c){}

    public String getCurrentText() {
        return this.currentText;
    }

    public String getCurrentWord() {
        return this.currentText.split(" ")[0];
    }

    public void trimFirstWord() {
        String replace = this.currentText.replaceFirst(
                String.format("%s ", this.getCurrentWord()), "");
        this.currentText = replace;
    }
}

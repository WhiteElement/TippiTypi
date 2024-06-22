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
        
        var label = new JLabel();
        label.setSize(200,100);
        frame.add(label);


        var displayer = new Displayer(totalText, label);
        frame.add(displayer.getTextField());
        
        frame.setVisible(true);
        

    }
}

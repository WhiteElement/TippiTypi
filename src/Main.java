import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        
        var path = Path.of("src/input.txt");
        String totalText = Files.readString(path, StandardCharsets.UTF_8);
        
        var frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMaximumSize(new Dimension(800, 600));
        frame.setLayout(new GridLayout(2, 3));
        
        var label = new JLabel();
        label.setSize(200,100);
        frame.add(label);


        var displayer = new Displayer(totalText, label);
        frame.add(displayer.getTextField());
        
        frame.setVisible(true);
        

    }
}

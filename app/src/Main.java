import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
  
  public static void main(String[] args) {
    Clippy clippy = new Clippy();
    clippy.setDefaultCloseOperation(EXIT_ON_CLOSE);
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
    Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
    int x = (int) rect.getMaxX();
    int y = (int) rect.getMaxY() - clippy.getHeight();
    clippy.setLocation(x, y);
    clippy.setVisible(true);
    
    RunShellCommandFromJava.Terminal();
  }
}

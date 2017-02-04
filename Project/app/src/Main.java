import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener {
  
  private static JTextField textfield;
  
  private static void findingTriangle() {
    /*
    ADDING JBUTTON'S EVENT
     */
    JButton jButton;
    jButton = new JButton("Click");
    jButton.addActionListener(new Main());
    /*
    ADDING JTEXTFIELD'S EVENT
     */
    textfield = new JTextField("", 30);
    textfield.addActionListener(new Main());
    /*
    BUILDING JFRAME
     */
    JFrame jf = new JFrame();
    JPanel panel = new JPanel();
    jf.setSize(500, 500);
    jf.setVisible(true);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.add(panel);
    JLabel jl = new JLabel("oi im clippy watchu want nig");
    panel.add(jl);
    panel.add(textfield);
    panel.add(jButton);
    /*
    PRESSING ENTER OR PRESSING BUTTON ACTIVATES EVENT (see actionPerformed)
     */
  }
  
  public static void main(String[] args) {
    findingTriangle();
  }
  
  @Override
  public void actionPerformed(ActionEvent arg0) {
    String s;
    s = textfield.getText();
    File f = new File("./out/fileOutput.txt");
      try {
        PrintStream p = new PrintStream(f);
        p.println(s);
      } catch (FileNotFoundException e) {
        //
      }
  }
}

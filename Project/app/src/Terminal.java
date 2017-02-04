import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.swing.*;

public class Terminal extends JFrame implements ActionListener {
  
  private static JTextField textfield;
  
  private static void createTerminal() {
    /*
    ADDING JTEXTFIELD'S EVENT
     */
    textfield = new JTextField("", 80);
    textfield.setBackground(Color.getHSBColor(332, 0.54f, 0.18f));
    textfield.setBorder(BorderFactory.createEmptyBorder());
    textfield.addActionListener(new Terminal());
    /*
    BUILDING JFRAME
     */
    JFrame jf = new JFrame();
    JPanel panel = new Panel(textfield, "oi im clippy watchu want nig");
    
    GridBagConstraints gc = new GridBagConstraints();
    jf.setSize(500, 500);
    jf.setVisible(true);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.add(panel);
    /*
    PRESSING ENTER OR PRESSING BUTTON ACTIVATES EVENT (see actionPerformed)
     */
  }
  
  @Override
  public void actionPerformed(ActionEvent arg0) {
    String s;
    s = textfield.getText();
    Micr
  }
}

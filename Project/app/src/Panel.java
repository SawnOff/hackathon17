import javax.swing.*;

public class Panel extends JPanel {
  
  private final JTextField textField;
  private final JLabel label;
  
  public Panel(JTextField textField, String labelText) {
    super();
    this.textField = textField;
    this.label = new JLabel(labelText);
    this.add(label);
    this.add(textField);
  }
  
  
  
}

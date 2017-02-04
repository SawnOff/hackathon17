import javax.swing.*;

public class Clippa extends JFrame {
  private JTextField enterYourQuestionTextField;

  public Clippa() {
    super("Label");
    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public static void main(String[] args) {
    Clippa clippa = new Clippa();
  }
}

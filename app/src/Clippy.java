import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Clippy extends JFrame implements ActionListener {

  private JLabel answer;
  private JTextField questionField;

  Clippy() {
    super("Clippy");
    Box totalBox = Box.createVerticalBox();
    add(totalBox);
    setUndecorated(true);
    setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));

    Box upperBox = Box.createHorizontalBox();
    upperBox.setAlignmentX(Box.CENTER_ALIGNMENT);
    totalBox.add(upperBox);

    JLabel image = new JLabel(new ImageIcon("Clippy.png"));
    image.setAlignmentX(JLabel.LEFT_ALIGNMENT);
    upperBox.add(image);

    JLabel poseTheQuestion = new JLabel("Ask Clippy a question:");
    poseTheQuestion.setOpaque(true);
    poseTheQuestion.setBackground(Color.GRAY);
    poseTheQuestion.setAlignmentX(JLabel.CENTER_ALIGNMENT);
    totalBox.add(poseTheQuestion);

    this.questionField = new JTextField(20);
    questionField.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
    questionField.addActionListener(this);
    totalBox.add(questionField);

    this.answer = new JLabel("<html> Hi! I am Clippy, <br>" +
            "your Linux assistant. <br>" +
            "Would you like some assistance today? </html>");
    Dimension dim = new Dimension(300, 300);
    answer.setMinimumSize(dim);
    answer.setPreferredSize(dim);
    answer.setMaximumSize(dim);
    answer.setOpaque(true);
    answer.setBackground(Color.yellow);
    answer.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
    upperBox.add(answer);

  }

  private void setAnswer(String newAnswer) {
    answer.setText(newAnswer);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    //lewis(questionField.getText());
    String openHTML = "<html><body style='width: 200px'>";
    String closeHTML = "</html>";
    setAnswer(openHTML + questionField.getText() + closeHTML);
    questionField.setText("");
    
  }

}

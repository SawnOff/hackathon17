import javax.swing.*;
import java.awt.*;


public class Clippy extends JFrame {

  public static void main(String[] args) {
    Clippy clippy = new Clippy();
    clippy.setDefaultCloseOperation( EXIT_ON_CLOSE );
    clippy.pack();
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
    Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
    int x = (int)rect.getMaxX();
    int y = (int)rect.getMaxY()- clippy.getHeight();
    clippy.setLocation(x,y);
    clippy.setVisible(true);
  }

  public Clippy() {
    super("Clippy");
    Box totalBox = Box.createVerticalBox();
    add(totalBox);
    setUndecorated(true);
    setBackground(new Color(1.0f,1.0f,1.0f,0.0f));


    Box upperBox = Box.createHorizontalBox();
    upperBox.setAlignmentX(Box.CENTER_ALIGNMENT);
    totalBox.add(upperBox);

    JLabel image = new JLabel(new ImageIcon("/home/cheukwing/Programming/misc/hackathon17/Clippy.png"));
    image.setAlignmentX(JLabel.LEFT_ALIGNMENT);
    upperBox.add(image);

    JLabel poseTheQuestion = new JLabel("Ask Clippy a question:");
    poseTheQuestion.setAlignmentX(JLabel.CENTER_ALIGNMENT);
    totalBox.add(poseTheQuestion);

    JTextField questionField = new JTextField(20);
    questionField.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
    totalBox.add(questionField);

    JLabel answer = new JLabel("fkosjfhhdsajfkhlsdkafhsakdfhsdakjfhlsadkfhasdlk");
    answer.setOpaque(true);
    answer.setBackground(Color.yellow);
    answer.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
    upperBox.add(answer);

  }
}

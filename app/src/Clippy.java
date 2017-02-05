import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Clippy extends JFrame implements ActionListener {
  
  private JLabel answer;
  private JTextField questionField;
  private JLabel poseTheQuestion;
  
  public static void main(String[] args) {
    Clippy clippy = new Clippy();
    clippy.setDefaultCloseOperation(EXIT_ON_CLOSE);
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
    Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
    int x = (int) rect.getMaxX();
    int y = (int) rect.getMaxY() - clippy.getHeight();
    clippy.setLocation(x, y);
    clippy.pack();
    clippy.setVisible(true);
    
    RunShell.Terminal();
    
  }
  
  public Clippy() {
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
    
    this.poseTheQuestion = new JLabel("Ask Clippy a question:");
    poseTheQuestion.setOpaque(true);
    poseTheQuestion.setBackground(Color.GRAY);
    poseTheQuestion.setAlignmentX(JLabel.CENTER_ALIGNMENT);
    totalBox.add(poseTheQuestion);
    
    this.questionField = new JTextField(20);
    questionField.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
    questionField.addActionListener(this);
    totalBox.add(questionField);
    
    Border paddingBorder = BorderFactory.createEmptyBorder(10,30,10,10);

    this.answer = new JLabel("<html> Hi! I am Clippy, <br>" +
        "your Linux assistant. <br>" +
        "Would you like some assistance today? </html>");
    Dimension dim = new Dimension(300, 300);
    answer.setBorder(paddingBorder);
    answer.setMinimumSize(dim);
    answer.setPreferredSize(dim);
    answer.setMaximumSize(dim);
    answer.setIcon(new ImageIcon("speech3.png"));
    //answer.setOpaque(true);
    //answer.setBackground(Color.YELLOW);
    answer.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
    answer.setHorizontalTextPosition(JLabel.CENTER);
    upperBox.add(answer);
    upperBox.add(Box.createHorizontalGlue());

//    JLabel bubble = new JLabel(new ImageIcon("speech3.png"));
//    //bubble.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
//    upperBox.add(bubble);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    String openHTML = "<html><body style='width: 200px'>";
    String closeHTML = "</html>";
    answer.setText("I'm thinking...");
    answer.paintImmediately(answer.getVisibleRect());
    String input = questionField.getText();
    String response = ResponseProcessor.respondToQ(MicrosoftHttpRequest.sendText(input));
    answer.setText(openHTML + response + closeHTML);
    questionField.setText("");
  }
  
}

//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//
//public class SwingContainerDemo {
//  private JFrame mainFrame;
//  private JLabel headerLabel;
//  private JLabel statusLabel;
//  private JPanel controlPanel;
//  private JLabel msglabel;
//
//  public SwingContainerDemo(){
//    prepareGUI();
//  }
//  public static void main(String[] args){
//    SwingContainerDemo  swingContainerDemo = new SwingContainerDemo();
//    swingContainerDemo.showJFrameDemo();
//  }
//  private void prepareGUI(){
//    mainFrame = new JFrame("CLIPPY");
//    mainFrame.setSize(400,400);
//    mainFrame.setLayout(new GridLayout(3, 1));
//
//    mainFrame.addWindowListener(new WindowAdapter() {
//      public void windowClosing(WindowEvent windowEvent){
//        System.exit(0);
//      }
//    });
//    headerLabel = new JLabel("", JLabel.TOP);
//    statusLabel = new JLabel("",JLabel.LEFT);
//    statusLabel.setSize(350,100);
//    msglabel = new JLabel("Let's have SEX", JLabel.LEADING);
//
//    controlPanel = new JPanel();
//    controlPanel.setLayout(new FlowLayout());
//
//    mainFrame.add(headerLabel);
//    mainFrame.add(controlPanel);
//    mainFrame.add(statusLabel);
//    mainFrame.setVisible(true);
//  }
//  private void showJFrameDemo(){
//    headerLabel.setText("Container in action: JFrame");
//    final JFrame frame = new JFrame();
//    frame.setSize(300, 300);
//    frame.setLayout(new FlowLayout());
//    frame.add(msglabel);
//
//    frame.addWindowListener(new WindowAdapter() {
//      public void windowClosing(WindowEvent windowEvent){
//        frame.dispose();
//      }
//    });
//    JButton okButton = new JButton("Click here to see CLIPPY in Action");
//    okButton.addActionListener(new ActionListener() {
//      public void actionPerformed(ActionEvent e) {
//        statusLabel.setText("Was it tiring ???");
//        frame.setVisible(true);
//      }
//    });
//    controlPanel.add(okButton);
//    mainFrame.setVisible(true);
//  }
//}

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }

        JFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      }
    });
  }

  public MainFrame() {
    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel gridbagPanel = new JPanel();
    this.setLayout(new BorderLayout());

    gridbagPanel.setLayout(new GridBagLayout());
    GridBagConstraints gc = new GridBagConstraints();

    JLabel nameLabel = new JLabel("");
    nameLabel.setForeground(WHITE);
    nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
    nameLabel.setFont(new Font("ComicSans", Font.PLAIN, 24));
    mainPanel.add(nameLabel, BorderLayout.NORTH);
    //Color myPurple = new Color (128, 0, 128);
    mainPanel.setBackground(BLACK);
    gridbagPanel.setBackground(BLACK);
    String username = System.getProperty("user.name");
    JLabel money = new JLabel(">" + username + ":");
    money.setForeground(WHITE);
    gc.gridx = 0;
    gc.gridy = 0;
    gc.anchor = GridBagConstraints.NORTHWEST;
    gc.insets = new Insets(2, 0, 0, 2);
    gridbagPanel.add(money, gc);

    JLabel job = new JLabel("How u doin bruv ???");
    gc.gridx = 0;
    gc.gridy = 1;
    gc.insets = new Insets(2, 0, 0, 2);
    gc.anchor = GridBagConstraints.NORTHWEST;
    gc.weightx = 1;
    gc.weighty = 1;
    gridbagPanel.add(job, gc);

    mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
    mainPanel.add(gridbagPanel, BorderLayout.WEST);

    add(mainPanel);
    getContentPane().revalidate();


  }
}
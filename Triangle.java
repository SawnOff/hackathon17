//import javax.swing.*;
//
//public class Main {
//    /**
//     * Create the GUI and show it.  For thread safety,
//     * this method should be invoked from the
//     * event-dispatching thread.
//     */
//    private static void createAndShowGUI() {
//        //Create and set up the window.
//        JFrame frame = new JFrame("HelloWorldSwing");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        //Add the ubiquitous "Hello World" label.
//        JLabel label = new JLabel("Hello World");
//        frame.getContentPane().add(label);
//
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        //Schedule a job for the event-dispatching thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
//    }
//}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Triangle extends JFrame implements ActionListener {

    static Scanner sc = new Scanner(System.in);
    static String s;
    static JTextField textfield;
    static JButton jButton;

    public static void findingTriangle() {

        JFrame jf = new JFrame();
        textfield = new JTextField("", 30);
        jButton = new JButton("Click");
        jButton.addActionListener(new Triangle());
        JPanel panel = new JPanel();
        JLabel jl = new JLabel("Triangle Area Calculator");
        jf.setSize(500, 500);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(panel);
        panel.add(jl);
        panel.add(textfield);
        panel.add(jButton);
    }

    public static void main(String[] args) {

        findingTriangle();

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        s = textfield.getText();

    }
}

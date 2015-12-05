package ui;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JTextPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import datareceiver.DataReceiver;


public class ReceiverUI {

  private JFrame frmPerceptron;

  private JTextField textField;

  private JTextField textField_1;

  private JTextField textField_2;

  private JTextField textField_3;

  File TrainData;

  File TestData;

  File Result;

  File plotTrainData;

  int KnnNumber;

  private JTextField textField_4;

  private JTextField textField_5;

  private JTextField textField_8;

  private JTextField textField_9;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ReceiverUI window = new ReceiverUI();
          window.frmPerceptron.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public ReceiverUI() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmPerceptron = new JFrame("Perceptron");
    frmPerceptron.setTitle("Receiver");
    frmPerceptron.setBackground(new Color(238, 238, 238));
    frmPerceptron.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frmPerceptron.setBounds(150, 150, 600, 350);
    frmPerceptron.getContentPane().setLayout(null);

    JPanel panel_3 = new JPanel();
    panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
            "Confusion Matrix", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    panel_3.setBounds(17, 144, 257, 168);
    frmPerceptron.getContentPane().add(panel_3);
    panel_3.setLayout(null);

    JLabel lblSp = new JLabel("True positive");
    lblSp.setBounds(26, 26, 103, 16);
    panel_3.add(lblSp);

    JLabel lblPetalLength = new JLabel("False positive");
    lblPetalLength.setBounds(147, 26, 103, 16);
    panel_3.add(lblPetalLength);

    JLabel lblSepalWidth = new JLabel("True Negative");
    lblSepalWidth.setBounds(147, 97, 103, 16);
    panel_3.add(lblSepalWidth);

    JLabel lblPetalWidth = new JLabel("False Negative");
    lblPetalWidth.setBounds(26, 97, 103, 16);
    panel_3.add(lblPetalWidth);
    // SL
    textField = new JTextField();
    textField.setBounds(26, 54, 91, 29);
    panel_3.add(textField);
    textField.setColumns(10);
    // SW
    textField_1 = new JTextField();
    textField_1.setBounds(147, 54, 91, 28);
    panel_3.add(textField_1);
    textField_1.setColumns(10);
    // PL
    textField_2 = new JTextField();
    textField_2.setBounds(147, 123, 91, 28);
    panel_3.add(textField_2);
    textField_2.setColumns(10);
    // PW
    textField_3 = new JTextField();
    textField_3.setBounds(26, 123, 91, 28);
    panel_3.add(textField_3);
    textField_3.setColumns(10);

    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
            "Accuracy", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    panel.setBounds(17, 51, 257, 87);
    frmPerceptron.getContentPane().add(panel);

    JLabel lblPrecision = new JLabel("Precision");
    lblPrecision.setBounds(26, 30, 103, 16);
    panel.add(lblPrecision);

    JLabel lblRecall = new JLabel("Recall");
    lblRecall.setBounds(26, 58, 103, 16);
    panel.add(lblRecall);

    textField_4 = new JTextField();
    textField_4.setColumns(10);
    textField_4.setBounds(127, 24, 103, 29);
    panel.add(textField_4);

    textField_5 = new JTextField();
    textField_5.setColumns(10);
    textField_5.setBounds(127, 52, 103, 28);
    panel.add(textField_5);

    JButton button = new JButton("Plot 2D");
    button.setBounds(26, 244, 90, 29);
    panel.add(button);

    JButton button_1 = new JButton("Plot 3D");
    button_1.setBounds(154, 244, 90, 29);
    panel.add(button_1);

    JPanel panel_2 = new JPanel();
    panel_2.setLayout(null);
    panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
            "Features and Weights", TitledBorder.LEADING, TitledBorder.TOP, null,
            new Color(0, 0, 0)));
    panel_2.setBounds(286, 51, 293, 261);
    frmPerceptron.getContentPane().add(panel_2);

    JLabel lblFeature = new JLabel("Weight 1");
    lblFeature.setBounds(49, 154, 69, 35);
    panel_2.add(lblFeature);

    JLabel lblFeature_1 = new JLabel("Weight 2");
    lblFeature_1.setBounds(49, 205, 69, 16);
    panel_2.add(lblFeature_1);

    textField_8 = new JTextField();
    textField_8.setColumns(10);
    textField_8.setBounds(130, 157, 103, 29);
    panel_2.add(textField_8);

    textField_9 = new JTextField();
    textField_9.setColumns(10);
    textField_9.setBounds(130, 199, 103, 28);
    panel_2.add(textField_9);

    JTextPane txtpnSdfasdfsfs = new JTextPane();
    txtpnSdfasdfsfs.setFont(new Font("Apple LiGothic", Font.PLAIN, 15));
    txtpnSdfasdfsfs
            .setText("  Feature 1: one of 8 lines has 3 \"X\"\n  \"1\" for true, \"-1\" for false\n\n  Feature 2: none of 8 lines has 3 \"O\" &&\n  total number of \"O\" > \"X\" total number\n  \"1\" for true, \"-1\" for false");
    txtpnSdfasdfsfs.setBounds(17, 37, 256, 105);
    panel_2.add(txtpnSdfasdfsfs);
    
    JButton btnReceiveAndTrain = new JButton("Step 1. Click to Prepare");
    btnReceiveAndTrain.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        try {
          double[] res = DataReceiver.dataReceiver();
          NumberFormat formatter = new DecimalFormat("#0.00000000");
          NumberFormat formatter2 = new DecimalFormat("#0");
          textField_4.setText(formatter.format(res[0]));
          textField_5.setText(formatter.format(res[1]));
          textField.setText(formatter2.format(res[2]));
          textField_1.setText(formatter2.format(res[3]));
          textField_3.setText(formatter2.format(res[4]));
          textField_2.setText(formatter2.format(res[5]));
          textField_8.setText(formatter.format(res[6]));
          textField_9.setText(formatter.format(res[7]));
        } catch (Exception e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
    });
    btnReceiveAndTrain.setBounds(207, 10, 181, 29);
    frmPerceptron.getContentPane().add(btnReceiveAndTrain);
    frmPerceptron.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    frmPerceptron.setVisible(true);
  }
}

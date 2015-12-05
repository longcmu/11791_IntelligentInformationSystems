package ui;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JButton;

import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.io.File;

import datasender.DataSender;

public class SenderUI {

  private JFrame frmPerceptron;

  File TrainData;

  File TestData;

  File Result;

  File plotTrainData;

  int KnnNumber;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          SenderUI window = new SenderUI();
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
  public SenderUI() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmPerceptron = new JFrame("Perceptron");
    frmPerceptron.setTitle("Sender");
    frmPerceptron.setBackground(new Color(238, 238, 238));
    frmPerceptron.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frmPerceptron.setBounds(150, 150, 600, 150);
    frmPerceptron.getContentPane().setLayout(null);

    JPanel panel_1 = new JPanel();
    panel_1.setBounds(17, 16, 565, 81);
    frmPerceptron.getContentPane().add(panel_1);
    panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
            "Data Sender", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

    JButton btnFile = new JButton("Step 2. Choose Input File");
    panel_1.add(btnFile);
    btnFile.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(jfc);
        TrainData = jfc.getSelectedFile();
      }
    });

    JButton btnRunnn = new JButton("Step 3. Send Data");
    btnRunnn.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {

        try {
          DataSender.dataSender(TrainData.getPath());
        } catch (Exception e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }

      }
    });
    panel_1.add(btnRunnn);

    JLabel lblHostPort = new JLabel("Host: 127.0.0.1   Port: 7777");
    lblHostPort.setBounds(17, 94, 273, 16);
    frmPerceptron.getContentPane().add(lblHostPort);
    frmPerceptron.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    frmPerceptron.setVisible(true);
  }
}

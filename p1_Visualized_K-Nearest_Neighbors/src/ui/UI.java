package ui;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import mt.MersenneTwisterFast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JProgressBar;

public class UI {

  private JFrame frmRandomNumberGenerator;

  private JTextField textField_1;

  private JTextField textField_2;

  private JTextField textField_3;

  File TrainData;

  File TestData;

  File Result;

  File plotTrainData;

  private JTextField textField_4;

  private JTextField textField_5;

  long SEED;

  BigInteger length;

  JProgressBar progressBar;

  private JTextField textField_6;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          UI window = new UI();
          window.frmRandomNumberGenerator.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public UI() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {

    frmRandomNumberGenerator = new JFrame("Random Number Generator");
    frmRandomNumberGenerator.setTitle("Random Number Generator");
    frmRandomNumberGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frmRandomNumberGenerator.setBounds(150, 150, 600, 550);
    frmRandomNumberGenerator.getContentPane().setLayout(null);

    JPanel panel_3 = new JPanel();
    panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
            "Statistics", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    panel_3.setBounds(17, 313, 565, 180);
    frmRandomNumberGenerator.getContentPane().add(panel_3);
    panel_3.setLayout(null);

    JLabel lblPetalLength = new JLabel("Number of \"0\"");
    lblPetalLength.setBounds(123, 21, 103, 16);
    panel_3.add(lblPetalLength);

    JLabel lblSepalWidth = new JLabel("Number of \"1\"");
    lblSepalWidth.setBounds(123, 60, 103, 16);
    panel_3.add(lblSepalWidth);

    JLabel lblPetalWidth = new JLabel("Data Bias");
    lblPetalWidth.setBounds(123, 99, 103, 16);
    panel_3.add(lblPetalWidth);
    // SW
    textField_1 = new JTextField();
    textField_1.setEditable(false);
    textField_1.setBounds(238, 15, 205, 28);
    panel_3.add(textField_1);
    textField_1.setColumns(10);
    // PL
    textField_2 = new JTextField();
    textField_2.setEditable(false);
    textField_2.setBounds(238, 54, 205, 28);
    panel_3.add(textField_2);
    textField_2.setColumns(10);
    // PW
    textField_3 = new JTextField();
    textField_3.setEditable(false);
    textField_3.setForeground(Color.RED);
    textField_3.setBounds(238, 93, 205, 28);
    panel_3.add(textField_3);
    textField_3.setColumns(10);

    textField_6 = new JTextField();
    textField_6.setForeground(Color.BLACK);
    textField_6.setEditable(false);
    textField_6.setColumns(10);
    textField_6.setBounds(238, 133, 205, 28);
    panel_3.add(textField_6);

    JLabel lblTimeUsed = new JLabel("Time Used");
    lblTimeUsed.setBounds(123, 139, 103, 16);
    panel_3.add(lblTimeUsed);

    JPanel panel_1 = new JPanel();
    panel_1.setBounds(17, 26, 565, 147);
    frmRandomNumberGenerator.getContentPane().add(panel_1);
    panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
            "Control Panel", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    panel_1.setLayout(null);

    JButton btnOutputPath = new JButton("Choose an Output Path");
    btnOutputPath.setBounds(20, 18, 320, 29);
    panel_1.add(btnOutputPath);
    btnOutputPath.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(1);
        jfc.showOpenDialog(jfc);
        Result = jfc.getSelectedFile();
      }
    });

    NumberFormat formatter3 = new DecimalFormat("#0.000");
    NumberFormat formatter7 = new DecimalFormat("#0.0000000");
    JButton btnRunnn = new JButton("Go");
    btnRunnn.setBounds(389, 59, 155, 29);
    btnRunnn.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        long START = System.nanoTime(); // out
        new Thread(new Runnable() {
          @Override
          public void run() {

            textField_1.setText("");
            textField_2.setText("");
            textField_3.setText("");
            textField_6.setText("");
            progressBar.setValue(0);

            String resultPath = Result.toString();
            FileWriter fw = null;
            File myFilePath = new File(resultPath + "/outputFile.txt");
            if (myFilePath.exists()) {
              myFilePath.delete();
            }
            try {
              fw = new FileWriter(resultPath + "/outputFile.txt");
            } catch (IOException e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
            }
            ;

            length = new BigInteger(textField_4.getText());
            int oneNo = 0;
            int zeroNo = 0;
            MersenneTwisterFast r = new MersenneTwisterFast(SEED);
            BigInteger one = new BigInteger("1");
            for (BigInteger i = one; !i.equals(length.add(one)); i = i.add(one)) {
              if (r.nextBoolean()) {
                try {
                  fw.write("1,");
                } catch (IOException e1) {
                  // TODO Auto-generated catch block
                  e1.printStackTrace();
                }
                oneNo++;
              } else {
                zeroNo++;
                try {
                  fw.write("0,");
                } catch (IOException e1) {
                  // TODO Auto-generated catch block
                  e1.printStackTrace();
                }
              }
              
              BigInteger zero = new BigInteger("0");
              BigInteger oneHundred = new BigInteger("100");
              BigInteger oneHundredThousand = new BigInteger("100000");
              if (i.mod(oneHundredThousand).equals(zero)) {
                try {
                  fw.flush();
                  textField_1.setText(zeroNo + "");
                  textField_2.setText(oneNo + "");

                  textField_3.setText(formatter7.format((double) Math.abs(zeroNo - oneNo)
                          / (double) (length.intValue()) * 100)
                          + "%");
                } catch (IOException e1) {
                  // TODO Auto-generated catch block
                  e1.printStackTrace();
                }
                int percent = (i.multiply(oneHundred).divide(length)).intValue();
                progressBar.setValue(percent);
                textField_6.setText(formatter3.format((double) (System.nanoTime() - START)
                        / (double) 1000000000)
                        + " (s)");
              }
            }
            try {
              fw.flush();
              fw.close();
            } catch (IOException e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
            }
            textField_1.setText(zeroNo + "");
            textField_2.setText(oneNo + "");
            textField_3.setText(formatter7.format((double) Math.abs(zeroNo - oneNo)
                    / (double) (length.intValue()) * 100)
                    + "%");
            textField_6.setText(formatter3.format((double) (System.nanoTime() - START)
                    / (double) 1000000000)
                    + " (s)");
            progressBar.setValue(100);
          }
        }).start();
      }
    });
    panel_1.add(btnRunnn);

    textField_4 = new JTextField();
    textField_4.setColumns(10);
    textField_4.setBounds(152, 99, 188, 29);
    panel_1.add(textField_4);

    JLabel lblLength = new JLabel("Set the Length:");
    lblLength.setBounds(43, 105, 97, 16);
    panel_1.add(lblLength);

    JButton btnGenerateASeed = new JButton("Generate a Seed:");
    btnGenerateASeed.addMouseListener(new MouseAdapter() {

      @Override
      public void mouseClicked(MouseEvent e) {

        SEED = System.nanoTime(); // out
        textField_5.setText(SEED + "");
      }
    });
    btnGenerateASeed.setBounds(20, 59, 129, 29);
    panel_1.add(btnGenerateASeed);

    textField_5 = new JTextField();
    textField_5.setEditable(false);
    textField_5.setColumns(10);
    textField_5.setBounds(152, 58, 188, 29);
    panel_1.add(textField_5);

    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
            "Progress", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
    panel.setBounds(17, 198, 565, 84);
    frmRandomNumberGenerator.getContentPane().add(panel);

    progressBar = new JProgressBar();
    progressBar.setForeground(new Color(0, 0, 0));
    progressBar.setToolTipText("");
    progressBar.setBounds(21, 35, 522, 20);
    panel.add(progressBar);
    progressBar.setStringPainted(true);

    JLabel lblLongHeV = new JLabel("©Long He \nV0.1\n");
    lblLongHeV.setBounds(491, 505, 103, 16);
    frmRandomNumberGenerator.getContentPane().add(lblLongHeV);

    frmRandomNumberGenerator.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    frmRandomNumberGenerator.setVisible(true);
  }
}

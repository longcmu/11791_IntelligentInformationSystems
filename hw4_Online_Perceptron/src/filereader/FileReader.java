package filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileReader {
  public static String[][] fileReader(String path) {
    String[] line = new String[958];
    int i = 0;
    try {
      String encoding = "GBK";
      File file = new File(path);
      if (file.isFile() && file.exists()) {
        InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        while ((lineTxt = bufferedReader.readLine()) != null) {
          line[i] = lineTxt;
          i++;
        }
        read.close();
      } else {
        System.out.println("cannot find the file");
      }
    } catch (Exception e) {
      System.out.println("error in reading the file");
      e.printStackTrace();
    }

    String[][] data = new String[958][10];
    for (int j = 0; j < 958; j++) {
      data[j] = line[j].split(",");
    }
    for (int k = 0; k < 958; k++) {
      if (data[k][9].equals("positive")) {
        data[k][9] = "P";
      } else {
        data[k][9] = "N";
      }
    }
    return data;
  }

  public static void main(String[] args) {
    String filePath = "/Users/RonHe/Desktop/tic-tac-toe.data.txt";
    String[][] a = fileReader(filePath);
    for (int i = 0; i < 958; i++) {
      for (int j = 0; j < 10; j++) {
        System.out.println(a[i][j]);
      }
    }
  }
}

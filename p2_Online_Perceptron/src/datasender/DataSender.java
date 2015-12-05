package datasender;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import filereader.FileReader;

public class DataSender {
  // static String filePath = "/Users/RonHe/Desktop/tic-tac-toe.data.txt";
  static FileReader s = new FileReader();
  
  public static void dataSender(String filePath) throws Exception {
  //public static void main(String[] args) throws Exception {
    String host = "127.0.0.1";
    int port = 7777;
    Socket client = new Socket(host, port);
    Writer writer = new OutputStreamWriter(client.getOutputStream());
    String[][] data = FileReader.fileReader(filePath);
    for (int i = 0; i < 958; i++) {
      for (int j = 0; j < 10; j++) {
        writer.write(data[i][j]);
      }
    }    
    writer.flush();
    writer.close();
    client.close();
  }
}
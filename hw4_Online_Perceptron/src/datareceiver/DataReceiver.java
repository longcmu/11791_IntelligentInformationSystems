package datareceiver;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import perceptron.Perceptron;

public class DataReceiver {
  public static double[] dataReceiver() throws IOException {
  //public static void main(String[] args) throws IOException {
    Perceptron s = new Perceptron();
    int port = 7777;  
    ServerSocket server = new ServerSocket(port);  
    Socket socket = server.accept();  
    Reader reader = new InputStreamReader(socket.getInputStream());  
    char chars[] = new char[10];  
    int len;
    String[][] data = new String[958][10];
    int i = 0;
    while ((len=reader.read(chars)) != -1) {
      String line = new String(chars, 0, len);
      //System.out.println(line);
      char[] charArray = line.toCharArray();
      for (int f = 0; f < 10; f++) {
        data[i][f] = String.valueOf(charArray[f]);
      }
      i++;
    } 
    reader.close();  
    socket.close();  
    server.close();
    /*for (int k = 0; k < 958; k++) {
      for (int j = 0; j < 10; j++) {
        System.out.print(data[k][j]);
      }
      System.out.println();
    } */
    return s.perceptron(data);
 }  
}

















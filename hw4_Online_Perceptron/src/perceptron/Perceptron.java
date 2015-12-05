package perceptron;

public class Perceptron {
  double alpha = 0.5;
  
  public double[] perceptron(String[][] data) {
    int[][] feature = new int[958][2];

    int[][] numData = new int[958][10];
    for (int i = 0; i < 958; i++) {
      for (int j = 0; j < 9; j++) {
        if (data[i][j].equals("x")) {
          numData[i][j] = 1;
        } else if (data[i][j].equals("o")) {
          numData[i][j] = -1;
        } else {
          numData[i][j] = 0;
        }
        if (data[i][9].equals("P")) {
          numData[i][9] = 1;
        } else if (data[i][9].equals("N")) {
          numData[i][9] = -1;
        }
      }
    }

    for (int i = 0; i < 958; i++) {
      if ((3 == numData[i][0] + numData[i][1] + numData[i][2])
              || (3 == numData[i][3] + numData[i][4] + numData[i][5])
              || (3 == numData[i][6] + numData[i][7] + numData[i][8])
              || (3 == numData[i][0] + numData[i][3] + numData[i][6])
              || (3 == numData[i][1] + numData[i][4] + numData[i][7])
              || (3 == numData[i][2] + numData[i][5] + numData[i][8])
              || (3 == numData[i][0] + numData[i][4] + numData[i][8])
              || (3 == numData[i][2] + numData[i][4] + numData[i][6])) {
        feature[i][0] = 1;
      } else {
        feature[i][0] = -1;
      }

      int A;
      if ((-3 != numData[i][0] + numData[i][1] + numData[i][2])
              && (-3 != numData[i][3] + numData[i][4] + numData[i][5])
              && (-3 != numData[i][6] + numData[i][7] + numData[i][8])
              && (-3 != numData[i][0] + numData[i][3] + numData[i][6])
              && (-3 != numData[i][1] + numData[i][4] + numData[i][7])
              && (-3 != numData[i][2] + numData[i][5] + numData[i][8])
              && (-3 != numData[i][0] + numData[i][4] + numData[i][8])
              && (-3 != numData[i][2] + numData[i][4] + numData[i][6])) {
        A = 1;
      } else {
        A = -1;
      }

      int B;
      int temp = 0;
      for (int j = 0; j < 9; j++) {
        temp += numData[i][j];
      }
      if (temp < 0) {
        B = 1;
      } else {
        B = -1;
      }
      
      if (A > 0 && B > 0) {
        feature[i][1] = 1;
      } else {
        feature[i][1] = -1;
      }
    }

    // initialize original weight
    double[] weight = new double[2];
    int n = 2;
    for (int i = 0; i < n; i++) {
      weight[i] = Math.random() * 10.0 - 10.0;
    }
    
    // start train
    int TruePositive = 0;
    int FalsePositive = 0;
    int FalseNegative = 0;
    int TrueNegative = 0;
    for (int k = 0; k < 958; k++) {
       System.out.println(compute(feature[k], weight));
      // confusion matrix
      if ((compute(feature[k], weight) > 0) && (numData[k][9] == 1)) {
        TruePositive++;
      }
      if ((compute(feature[k], weight) <= 0) && (numData[k][9] == -1)) {
        TrueNegative++;
      }
      if ((compute(feature[k], weight) > 0) && (numData[k][9] == -1)) {
        FalsePositive++;
      }
      if ((compute(feature[k], weight) < 0) && (numData[k][9] == 1)) {
        FalseNegative++;
      }
      
      // update weight
      for (int l = 0; l < 2; l++) {
        weight[l] += alpha * (numData[k][9] - compute(feature[k], weight)) * feature[k][l];
      }
       // System.out.print(weight[0] + "  ");
       // System.out.println(weight[1]);
    }
    double precision = (double)TruePositive / (double)(TruePositive + FalsePositive);
    double recall = (double)TruePositive / (double)(TruePositive + FalseNegative);
    // System.out.println(precision);
    // System.out.println(recall);
    double[] res = new double[8];
    res[0] = precision;
    res[1] = recall;
    res[2] = TruePositive;
    res[3] = FalsePositive;
    res[4] = FalseNegative;
    res[5] = TrueNegative;
    res[6] = weight[0];
    res[7] = weight[1];
    
    return res;
  }

  public double compute(int[] feature, double[] weight) {
    double res = 0;
    for (int i = 0; i < feature.length; i++) {
      res = res + feature[i] * weight[i];
    }
    return res;
  }
}

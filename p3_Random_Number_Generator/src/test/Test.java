package test;

import java.math.BigInteger;
import mt.MersenneTwisterFast;

public class Test {
  public static void main(String[] args) {
    long SEED = System.nanoTime(); // out
    BigInteger length=new BigInteger("10000"); // in
    
    int A = 0;
    int B = 0;
    MersenneTwisterFast r = new MersenneTwisterFast(SEED);
    for (int i = 0; i < length.intValue(); i++) {
      if(r.nextBoolean()) {
        A++;
      } else {
        B++;
      }
    }
    System.out.println(A); // out
    System.out.println(B); // out
  }
}


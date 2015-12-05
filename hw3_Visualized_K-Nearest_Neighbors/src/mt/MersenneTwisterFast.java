package mt;

import java.io.Serializable;

public strictfp class MersenneTwisterFast implements Serializable, Cloneable {
  // Serialization
  private static final long serialVersionUID = -8219700664442619525L; // locked as of Version 15

  // Period parameters
  private static final int N = 624;

  private static final int M = 397;

  private static final int MATRIX_A = 0x9908b0df; // private static final * constant vector a

  private static final int UPPER_MASK = 0x80000000; // most significant w-r bits

  private static final int LOWER_MASK = 0x7fffffff; // least significant r bits

  // Tempering parameters
  private static final int TEMPERING_MASK_B = 0x9d2c5680;

  private static final int TEMPERING_MASK_C = 0xefc60000;

  private int mt[]; // the array for the state vector

  private int mti; // mti==N+1 means mt[N] is not initialized

  private int mag01[];

  /**
   * Constructor using a given seed. Though you pass this seed in as a long, it's best to make sure
   * it's actually an integer.
   *
   */
  public MersenneTwisterFast(long seed) {
    setSeed(seed);
  }

  synchronized public void setSeed(long seed) {
    mt = new int[N];

    mag01 = new int[2];
    mag01[0] = 0x0;
    mag01[1] = MATRIX_A;

    mt[0] = (int) (seed & 0xffffffff);
    for (mti = 1; mti < N; mti++) {
      mt[mti] = (1812433253 * (mt[mti - 1] ^ (mt[mti - 1] >>> 30)) + mti);
    }
  }

  public boolean nextBoolean() {
    int y;

    if (mti >= N) // generate N words at one time
    {
      int kk;
      final int[] mt = this.mt; // locals are slightly faster
      final int[] mag01 = this.mag01; // locals are slightly faster

      for (kk = 0; kk < N - M; kk++) {
        y = (mt[kk] & UPPER_MASK) | (mt[kk + 1] & LOWER_MASK);
        mt[kk] = mt[kk + M] ^ (y >>> 1) ^ mag01[y & 0x1];
      }
      for (; kk < N - 1; kk++) {
        y = (mt[kk] & UPPER_MASK) | (mt[kk + 1] & LOWER_MASK);
        mt[kk] = mt[kk + (M - N)] ^ (y >>> 1) ^ mag01[y & 0x1];
      }
      y = (mt[N - 1] & UPPER_MASK) | (mt[0] & LOWER_MASK);
      mt[N - 1] = mt[M - 1] ^ (y >>> 1) ^ mag01[y & 0x1];

      mti = 0;
    }

    y = mt[mti++];
    y ^= y >>> 11; // TEMPERING_SHIFT_U(y)
    y ^= (y << 7) & TEMPERING_MASK_B; // TEMPERING_SHIFT_S(y)
    y ^= (y << 15) & TEMPERING_MASK_C; // TEMPERING_SHIFT_T(y)
    y ^= (y >>> 18); // TEMPERING_SHIFT_L(y)

    return (boolean) ((y >>> 31) != 0);
  }
}
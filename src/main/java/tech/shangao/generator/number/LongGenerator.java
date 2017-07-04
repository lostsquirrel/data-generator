package tech.shangao.generator.number;

import java.util.Random;

public class LongGenerator {

    private static Random random = new Random(Double.doubleToLongBits(Math.random()));

    static final String BadBound = "bound must be positive";

    public static long random() {
        return random.nextLong();
    }

    public static long random(long bound) {
        if (bound < 0)
            throw new IllegalArgumentException(BadBound);
        return Math.abs(random.nextLong() % bound);
    }
}

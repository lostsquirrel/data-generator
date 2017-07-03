package tech.shangao.generator.number;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Random;

public class IntGenerator {
    private static final Logger log = LoggerFactory.getLogger(IntGenerator.class);

    private static Random random = new Random();

    /**
     * get a pseudo random int
     *
     * @return pseudo random int
     */
    public static int random() {
        seed();
        return random.nextInt();
    }

    /**
     * get a pseudo random int range [0, bound)
     *
     * @param bound maxBound, not include
     * @return random int
     */
    public static int random(int bound) {
        seed();
        return random.nextInt(bound);
    }

    /**
     * get a pseudo random int range [min, max)
     *
     * @param origin minBound, include
     * @param bound maxBound, not include
     * @return random int
     */
    public static int random(int origin, int bound) {
        seed();

        return origin + random.nextInt(bound);
    }

    private static void seed() {
        random.setSeed(new Date().getTime());
    }


    public static void main(String[] args) {

        log.debug("{}", Integer.MAX_VALUE - 1 + Integer.MAX_VALUE);
        log.debug("{}", random(Integer.MAX_VALUE - 1, Integer.MAX_VALUE));
    }
}

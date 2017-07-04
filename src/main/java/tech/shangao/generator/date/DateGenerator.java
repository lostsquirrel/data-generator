package tech.shangao.generator.date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.shangao.generator.number.LongGenerator;

import java.util.Calendar;
import java.util.Date;

public class DateGenerator {

    private static final Logger log = LoggerFactory.getLogger(DateGenerator.class);

    public static Date randam() {
        Calendar c = Calendar.getInstance();
        long timeInMillis = c.getTimeInMillis();
        long millis = timeInMillis - LongGenerator.random(timeInMillis);
        c.setTimeInMillis(millis);
        return c.getTime();
    }

    public static Date computerFirstDate() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(0);
        return c.getTime();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            log.debug("{}", randam());
        }
        log.debug("{}", computerFirstDate());
    }
}

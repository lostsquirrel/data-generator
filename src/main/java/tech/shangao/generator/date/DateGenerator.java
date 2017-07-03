package tech.shangao.generator.date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.shangao.generator.number.IntGenerator;

import java.util.Calendar;
import java.util.Date;

public class DateGenerator {

    private static final Logger log = LoggerFactory.getLogger(DateGenerator.class);

    public static Date randam() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(c.getTimeInMillis() - Math.abs(IntGenerator.random()));
        return c.getTime();
    }

    public static Date computerFirstDate() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(0);
        return c.getTime();
    }

    public static void main(String[] args) {
        log.debug("{}", randam());
        log.debug("{}", computerFirstDate());
    }
}

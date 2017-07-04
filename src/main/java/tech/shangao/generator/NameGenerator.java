package tech.shangao.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.shangao.generator.number.IntGenerator;
import tech.shangao.generator.utils.ConfigUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NameGenerator {

    private static List<String> usFirstNames;

private static final Logger log = LoggerFactory.getLogger(NameGenerator.class);
    static {
        usFirstNames = ConfigUtils.loadUSFirstNames();
        log.debug("usFirstNames:{}", usFirstNames.size());
    }

    public static String random() {
        return usFirstNames.get(IntGenerator.random(usFirstNames.size()));
    }
    
    public static List<String> random(int num) {
        List<String> list = new ArrayList<>();
        Collections.shuffle(list);
        return list.subList(0, num);
    }
}

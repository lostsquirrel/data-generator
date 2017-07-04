package tech.shangao.generator;

import tech.shangao.generator.number.IntGenerator;
import tech.shangao.generator.utils.ConfigUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmailGenerator {

    private static List<String> mailDomains;

    private static List<String> allDomains;
    static {
        mailDomains = ConfigUtils.loadUSEmailDomains();
        allDomains = ConfigUtils.loadGlobalDomains();
        allDomains.addAll(mailDomains);
    }

    public static String random() {
        return allDomains.get(IntGenerator.random(allDomains.size()));
    }

    public static List<String> random(int size) {
        List<String> list = new ArrayList<>();
        int size1 = allDomains.size();
        while (size > size1) {
            list.addAll(allDomains);
            size -= size1;
        }
        if (size > 0) {
            Collections.shuffle(list);
            list.addAll(allDomains.subList(0, size));
        }
        Collections.shuffle(list);
        return list;
    }
}

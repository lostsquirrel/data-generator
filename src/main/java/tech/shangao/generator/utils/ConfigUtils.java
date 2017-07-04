package tech.shangao.generator.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigUtils {

    private static final Logger log = LoggerFactory.getLogger(ConfigUtils.class);

    private static final String FIRST_NAMES = "first_names/%s.txt";

    private static final String EMAIL_DOMAINS = "mail_domains/%s.txt";

    private static final String REGION_US = "us";

    private static final String REGION_GLOBAL = "global";


    public static List<String> loadFirstNames(String region) {
        return load(String.format(FIRST_NAMES, region));
    }


    public static List<String> loadUSFirstNames() {
        return loadFirstNames(REGION_US);
    }

    public static List<String> loadMailDomains(String region) {
        return load(String.format(EMAIL_DOMAINS, region));
    }

    public static List<String> loadUSEmailDomains() {
        return loadMailDomains(REGION_US);
    }

    public static List<String> load(String configName) {
        List<String> list = null;
        InputStream inputStream = null;
        BufferedReader br = null;
        try {
            inputStream = ConfigUtils.class.getClassLoader().getResourceAsStream(configName);
            br = new BufferedReader(new InputStreamReader(inputStream));
            list = br.lines().collect(Collectors.toList());
            log.debug("read from file {} as {} items", configName, list.size());
        } finally {
            if (list == null) {
                list = new ArrayList<>();
            }

            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public static List<String> loadGlobalDomains() {
        return loadMailDomains(REGION_GLOBAL);
    }
}

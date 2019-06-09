package com.zc.z01demo;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

public class T05Properties {
    // private static final Logger LOG = LoggerFactory.getLogger(T05Properties.class);
    @Test
    public void test01() throws FileNotFoundException, IOException {
        Properties properties = new Properties();
        //load一个流(InputStream或者Reader)
        properties.load(new FileInputStream(new File("jdbc.properties")));
        String user = properties.getProperty("user");
    }

    @Test
    public void testReadProps() {
        // TODO path
        String path = "";
        File configFile = new File(path);
        // LOG.info("Reading configuration from: " + configFile);
        try {
            if (!configFile.exists()) {
                throw new IllegalArgumentException(configFile.toString()
                        + " file is missing");
            }
            Properties cfg = new Properties();
            FileInputStream in = new FileInputStream(configFile);
            try {
                cfg.load(in);
            } finally {
                in.close();
            }

            parseProperties(cfg);
        } catch (IOException e) {
            // throw new ConfigException("Error processing " + path, e);
        }
    }

    public void parseProperties(Properties zkProp) throws IOException {
        for (Map.Entry<Object, Object> entry : zkProp.entrySet()) {
            String key = entry.getKey().toString().trim();
            String value = entry.getValue().toString().trim();
            if (key.equals("dataDir")) {

            } else if (key.equals("dataLogDir")) {

            }
        }
    }

}

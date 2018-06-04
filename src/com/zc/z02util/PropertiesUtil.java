package com.zc.z02util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;

public class PropertiesUtil
{
    private static Map<String, String> cachMap = new HashMap<String, String>();

    static
    {
        Properties props = new Properties();
        try
        {
            String rootPath = PropertiesUtil.class.getClassLoader().getResource("oracle.properties").getPath();
            props.load(new FileInputStream(rootPath));
            // 遍历方式1:使用entry遍历
            for (Map.Entry<Object, Object> every : props.entrySet())
            {
                cachMap.put((String) every.getKey(), (String) every.getValue());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key)
    {
        return cachMap.get(key);
    }

    @Test
    public void test()
    {
        System.out.println(PropertiesUtil.getProperty("driverClass"));
    }

    @Test
    public void testTrace2() throws FileNotFoundException, IOException
    {
        Properties props = new Properties();
        String rootPath = PropertiesUtil.class.getClassLoader().getResource("oracle.properties").getPath();
        props.load(new FileInputStream(rootPath));
        Enumeration<?> enumeration = props.propertyNames();
        while (enumeration.hasMoreElements())
        {
            String name = (String) enumeration.nextElement();
            String value = props.getProperty(name);
            if (value != null)
            {
                System.setProperty(name, value);
            }
        }
    }
}

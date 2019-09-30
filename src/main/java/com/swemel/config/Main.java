package com.swemel.config;

import org.apache.parquet.bytes.BytesUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(new File("config.xml")));
        props.getProperty("MQT_ALR");
        int a = 0;
        int b = 0;
        System.out.println(0 |0);
        System.out.println(0 | 1);
        System.out.println(1 | 0);
        System.out.println(1 | 1);
        byte[] x = BytesUtils.intToBytes(4);
        byte[] y = BytesUtils.intToBytes(120);
        System.out.println();
    }
}

package com.ycf.symbol;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author ycf
 */
public class Symbol {
    public static String cowSayService(String say, String eye, String path) {
        return String.format(getContent(path), say, eye);
    }

    /**
     * 读取图像
     *
     * @param path 图像路径
     * @return str图像
     */
    public static String getContent(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        FileInputStream inputStream = null;
        byte[] bytes = null;
        try {
            inputStream = new FileInputStream(file);
            int length = inputStream.available();
            bytes = new byte[length];
            inputStream.read(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String str = new String(bytes, StandardCharsets.UTF_8);
        return str;
    }
}

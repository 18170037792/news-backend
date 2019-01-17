package com;

import java.io.*;

public class count {

    public static int getProjectFileNumber(File file, String endsWith) throws IOException {
        int number = 0;
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File subFile : file.listFiles()) {
                    number += getProjectFileNumber(subFile, endsWith);
                }
            } else if (file.isFile() && file.getName().endsWith(endsWith)) {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while (br.readLine() != null) {
                    number += 1;
                }
            } else {
                System.out.println("===" + file.getAbsolutePath());
            }
        }
        return number;
    }

    public static void main(String[] args) throws IOException {
        //用法示例
        int num = getProjectFileNumber(new File("F:\\news-backend\\news-backend\\src\\main\\resources\\templates"), ".html");
        System.out.println(num);
    }


}

package wordcounter.test;

import wordcounter.test.Test;

import java.io.IOException;

public class TestRunner {
    private static String path = "D:\\123.txt";

    public static void main(String[] args) throws Exception {
        Test test = new Test(path);
        System.out.println(path);
        test.testCharNumCounter();
        test.testWordNumCounter();
        test.testLineNumCounter();
    }
}

package com.sluka.taras.util;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class ScannerSingleton {
    private static final Logger LOGGER = Logger.getLogger(ScannerSingleton.class);
    private static ScannerSingleton instance = null;
    private static Scanner scanner = null;

    private ScannerSingleton() {
        this.scanner = new Scanner(System.in);
    }

    public synchronized static ScannerSingleton getInstance() {
        if (instance == null) {
            instance = new ScannerSingleton();
        }
        return instance;
    }

    public Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public void closeScanner() {
        scanner.close();
    }
}

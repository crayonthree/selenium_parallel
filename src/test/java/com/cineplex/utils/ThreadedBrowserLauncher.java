package com.cineplex.utils;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ThreadedBrowserLauncher {

    public static void main(String[] args) throws Exception {
        
        // List of browsers
        List<String> browsers = ConfigReader.getBrowsers();

        // Looping through the browsers
        for (String browser : browsers) {
            final String threadBrowser = browser;

            //Thread for each browser
            Thread thread = new Thread(() -> {

                //Thread local thread-safe storage
                BrowserContext.setBrowser(threadBrowser);
                System.out.println("[" + Thread.currentThread().getName() + "] Running on: " + threadBrowser);

                //Result of test suite
                Result result = JUnitCore.runClasses(com.cineplex.runners.TestRunner.class);

                //Output failures
                for (Failure failure : result.getFailures()) {
                    System.out.println("Failure on [" + threadBrowser + "]: " + failure.toString());
                }

                //Output tests, and clear storage
                System.out.println("Finished tests on browser: " + threadBrowser);
                BrowserContext.clear();

            }, "Thread-" + threadBrowser);

            //Start thread
            thread.start();
        }
    }
}




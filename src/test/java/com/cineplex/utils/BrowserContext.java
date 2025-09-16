package com.cineplex.utils;

public class BrowserContext {
    private static final ThreadLocal<String> browserName = new ThreadLocal<>();

    public static void setBrowser(String browser) {
        browserName.set(browser);
    }

    public static String getBrowser() {
        return browserName.get();
    }

    public static void clear() {
        browserName.remove();
    }
}

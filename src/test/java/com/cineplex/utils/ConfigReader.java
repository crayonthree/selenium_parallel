package com.cineplex.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConfigReader {

    public static List<String> getBrowsers() throws Exception {
        for (String line : Files.readAllLines(Paths.get("src/test/resources/config.properties"))) {
            if (line.startsWith("browsers")) {
                String[] parts = line.split(":");
                return Arrays.asList(parts[1].trim().split(","));
            }
        }
        return Collections.emptyList();
    }
}

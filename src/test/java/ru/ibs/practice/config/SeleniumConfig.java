package ru.ibs.practice.config;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Getter
public class SeleniumConfig {
    private String baseUrl;
    private String chromeDriver;
    private String chromeDriverPath;
    private String chromeBrowserPath;

    public SeleniumConfig() {
        loadProperties();
    }

    private void loadProperties() {
        try (FileInputStream fileInputStream = new FileInputStream(
                "src/test/resources/config.properties")) {
            Properties properties = new Properties();
            properties.load(fileInputStream);

            baseUrl = properties.getProperty("base.url");
            chromeDriver = properties.getProperty("chrome.driver");
            chromeDriverPath = properties.getProperty("chrome.driver.path");
            chromeBrowserPath = properties.getProperty("browser.chrome.macos");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


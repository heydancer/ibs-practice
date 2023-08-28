package ru.ibs.practice.tests.ui.general;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.practice.config.SeleniumConfig;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static ChromeOptions chromeOptions;
    protected static SeleniumConfig config;

    @BeforeAll
    public static void setUp() {
        config = new SeleniumConfig();

        System.setProperty(config.getChromeDriver(), config.getChromeDriverPath());

        chromeOptions = new ChromeOptions();
        chromeOptions.setBinary(config.getChromeBrowserPath());

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void close() {
        driver.quit();
    }
}

package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.firefox.bin","/Applications/Firefox.app/Contents/MacOS/firefox");
//        System.setProperty("webdriver.gecko.driver","geckodriver");
//        File pathBinary = new File("/Applications/Firefox.app");
//        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
//        FirefoxOptions options = new FirefoxOptions();
//        options.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
//        driver = new FirefoxDriver(options);
        driver = new FirefoxDriver();
//        driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
        driver.get("https://www.youtube.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSearchVideo() {
        WebElement searchBox = driver.findElement(By.name("search_query"));
        WebElement searchButton = driver.findElement(By.id("search-icon-legacy"));
        searchBox.sendKeys("Learn Java in 10 hours");
        searchButton.click();
        WebElement firstResult = driver.findElement(By.id("video-title"));
        assertTrue(firstResult.getText().toLowerCase().contains("java"));
    }

    @Test
    public void testShortsPage() {
        driver.get("https://www.youtube.com/feed/trending");
        WebElement trendingHeader = driver.findElement(By.xpath("//yt-formatted-string[contains(text(), 'Trending')]"));
        assertTrue(trendingHeader.isDisplayed());
    }

    @Test
    public void testLogin() {
        WebElement signInButton = driver.findElement(By.xpath("//tp-yt-paper-button[@aria-label='Sign in']"));
        signInButton.click();
        WebElement emailField = driver.findElement(By.id("identifierId"));
        assertTrue(emailField.isDisplayed());
    }
}

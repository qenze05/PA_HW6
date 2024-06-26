package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.firefox.bin","/Applications/Firefox.app/Contents/MacOS/firefox");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("intl.accept_languages", "en-GB");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        driver = new FirefoxDriver(options);
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
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("video-title")));
        assertTrue(firstResult.getText().toLowerCase().contains("java"));
    }

    @Test
    public void testTrendingPage() {
        driver.get("https://www.youtube.com/feed/trending");
        WebDriverWait wait = new WebDriverWait(driver, 50);
        WebElement trendingHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Trending']")));
        assertTrue(trendingHeader.isDisplayed());
    }

    @Test
    public void testLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        WebElement signInButton = driver.findElement(By.xpath("//*[text()='Sign in']"));
        WebElement parent = signInButton.findElement(By.xpath("../.."));
        parent.click();
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
        assertTrue(emailField.isDisplayed());
    }
}

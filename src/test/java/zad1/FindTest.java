package zad1;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindTest {

    //Przykłady znajdowania elementów na stronie www bez elementów xpath

    private static WebDriver driver;

    @BeforeAll
    public static void setUpDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");


        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
        chromeOptions.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
        chromeOptions.addArguments("--headless"); // only if you are ACTUALLY running headless
        chromeOptions.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
        chromeOptions.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
        chromeOptions.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
        chromeOptions.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
        chromeOptions.addArguments("--disable-gpu");

        driver = new ChromeDriver(chromeOptions);
        // Implicity wait -> max czas na znalezienie elementu na stronie
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void setUp() throws Exception {
        driver.get("https://www.google.pl");
    }

    @AfterAll
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void findById() {
        WebElement element = driver.findElement(By.id("searchform"));
        assertNotNull(element);
    }

    @Test
    public void findByName() {
        WebElement element = driver.findElement(By.name("q"));
        assertNotNull(element);
    }

    @Test
    public void findByClass() {
        WebElement element = driver.findElement(By.className("gsfi"));
        assertNotNull(element);
    }

    @Test
    public void findBylinkText() {
        WebElement element = driver.findElement(By.linkText("Gmail"));
        assertNotNull(element);
    }

    @Test
    public void findByPartiallinkText() {
        WebElement element = driver.findElement(By.partialLinkText("ma"));
        assertNotNull(element);
    }

    @Test
    public void findByTagName() {
        WebElement element = driver.findElement(By.tagName("div"));
        assertNotNull(element);
    }

    @Test
    public void findByCssSelector() {
        WebElement element = driver.findElement(By.cssSelector("input.gsfi"));
        assertNotNull(element);
    }


}
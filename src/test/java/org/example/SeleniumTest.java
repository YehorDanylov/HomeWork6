package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        // Установка параметрів для Chrome WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\JavaHomeWork6\\chromedriver.exe");

        // Налаштування опцій Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-web-security");
        options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");

        // Ініціалізація веб-драйвера з опціями
        driver = new ChromeDriver(options);
    }

    @Test
    public void testGoogleSearch() {
        // Відкриття Google сторінки
        driver.get("https://www.google.com");

        // Пошук елементу для введення тексту
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium testing");

        // Виконання пошуку
        searchBox.submit();

        // Перевірка результатів пошуку
        assertTrue(driver.getTitle().startsWith("Selenium testing"));
    }



    @Test
    public void testGoogleLink() {
       // Відкриття Wikipedia сторінки
        driver.get("https://www.wikipedia.org/");

        // Отримання фактичного URL сторінки
        String actualUrl = driver.getCurrentUrl();

        assertEquals("https://www.wikipedia.org/",actualUrl );
    }

    @Test
    public void testSearchByClassName() {
        driver.get("https://www.wikipedia.org/");

        // Find the element by ID
        WebElement element = driver.findElement(By.className("central-textlogo-wrapper"));

        // Assert if the element is displayed
        assertTrue(element.isDisplayed());
    }


    @AfterEach
    public void tearDown() {
        // Закриття веб-драйвера після кожного тесту
        if (driver != null) {
            driver.quit();
        }
    }
}

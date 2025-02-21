package id.ac.ui.cs.advprog.eshop.functional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateProductFunctionalTest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Sesuaikan dengan path driver-mu
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/product/create");
    }

    @Test
    void testCreateProduct() {
        WebElement nameInput = driver.findElement(By.name("name"));
        WebElement quantityInput = driver.findElement(By.name("quantity"));
        WebElement submitButton = driver.findElement(By.tagName("button"));

        nameInput.sendKeys("Smartphone");
        quantityInput.sendKeys("20");
        submitButton.click();

        driver.get("http://localhost:8080/product/list");
        assertTrue(driver.getPageSource().contains("Smartphone"));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

/*
1. Go to https://www.qaclickacademy.com/practice.php
2. Enter first 3 letters of country in auto suggestive text box
3. Click random result from the option dropdown
*/
public class Assignment8 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        Random random = new Random();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String input = "ind";
        driver.manage().window().maximize();
        driver.get("https://www.qaclickacademy.com/practice.php");
        driver.findElement(By.cssSelector("#autocomplete")).sendKeys(Keys.ENTER, input);
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".ui-menu-item"))));
        int rand = random.nextInt(0, 1000) % 3;
        for(int i=0;i<=rand;i++){
            driver.findElement(By.cssSelector("#autocomplete")).sendKeys(Keys.DOWN);
        }
        driver.findElement(By.cssSelector("#autocomplete")).sendKeys(Keys.ENTER);
    }
}

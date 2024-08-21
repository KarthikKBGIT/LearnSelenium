import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AmazonInterviewQuestion1 {
    public static void main(String[] args){
        String[] vegtablesToSelect ={"Brocolli", "Brinjal"};
        int indexToSelect=1;
        List<String> vegsToSelect = Arrays.asList(vegtablesToSelect);
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        List<WebElement> vegtables = driver.findElements(By.cssSelector(".product-name"));
        for(WebElement vegtable: vegtables){
            if(vegsToSelect.contains(vegtable.getText().split("-")[0].trim())){
                driver.findElement(By.xpath("(//button[text()='ADD TO CART'])["+indexToSelect+"]")).click();
                continue;
            }
            indexToSelect++;
        }
        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".promoBtn")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".promoInfo"))));
        Assert.assertEquals(driver.findElement(By.cssSelector(".promoInfo")).getText(), "Code applied..!");
    }
}

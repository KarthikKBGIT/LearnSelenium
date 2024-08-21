import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignment3 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        String text = driver.findElement(By.xpath("//p[@class='text-center text-white']")).getText();
        String userName = text.split(" ")[2];
        String passWord = text.split(" ")[6];
        passWord = passWord.substring(0, passWord.length()-1);
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(passWord);
        driver.findElement(By.xpath("//input[@id='usertype' and @value='user']/following-sibling::span")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("okayBtn"))));
        driver.findElement(By.id("okayBtn")).click();
        driver.findElement(By.xpath("//select[@class='form-control']")).click();
        driver.findElement(By.xpath("(//option)[1]")).click();
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.id("signInBtn")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add ']")));
        List<WebElement> buttons = driver.findElements(By.xpath("//button[text()='Add ']"));
        for(WebElement button:buttons){
            button.click();
        }
        driver.findElement(By.xpath("//*[contains(text(),'Checkout')]")).click();
    }
}

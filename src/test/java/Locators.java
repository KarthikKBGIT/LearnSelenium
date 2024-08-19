import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("karthik.k.b");
        driver.findElement(By.name("inputPassword")).sendKeys("wrongPassword");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("karthik");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("karthik@outlook.com");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("karthik@gmail.com");
        driver.findElement(By.cssSelector("form input[placeholder='Phone Number']")).sendKeys("9597586233");
        driver.findElement(By.cssSelector("div button[class='reset-pwd-btn']")).click();
        System.out.println(driver.findElement(By.cssSelector("form p[class='infoMsg']")).getText());
        driver.quit();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
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
        String passwordMsg = driver.findElement(By.cssSelector("form p")).getText();
        String[] passwordArray = passwordMsg.split(" ");
        String passWord = passwordArray[4].substring(1, passwordArray[4].length()-1);
        driver.findElement(By.cssSelector("div.sign-up-container div.forgot-pwd-btn-conainer button.go-to-login-btn")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//input[contains(@id,'Username')]")).sendKeys("karthik");
        driver.findElement(By.cssSelector("input[name*='Pass']")).sendKeys(passWord);
        System.out.println(passWord);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".signInBtn")));
        System.out.println("Submit button is clickable");
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.login-container p"))));
        System.out.println(driver.findElement(By.cssSelector("div.login-container p")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("div.login-container p")).getText(), "You are successfully logged in.");
        driver.quit();
    }
}

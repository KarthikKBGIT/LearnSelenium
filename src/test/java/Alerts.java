import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Alerts {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        String name = "Karthik";
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("alertbtn")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(), "Hello "+name+", share this practice page and share your knowledge");
        driver.switchTo().alert().accept();
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("confirmbtn")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(), "Hello "+name+", Are you sure you want to confirm?");
        driver.switchTo().alert().dismiss();
    }
}

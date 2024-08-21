import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment2 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        String name="Karthik K B", Email="karthikkb@gmail.com", Password="2024@K", date="10-12-2000";
        driver.findElement(By.xpath("//div/input[@name='name']")).sendKeys(name);
        driver.findElement(By.xpath("//div/input[@name='email']")).sendKeys(Email);
        driver.findElement(By.xpath("//div/input[@type='password']")).sendKeys(Password);
        driver.findElement((By.xpath("//input[@type='checkbox']"))).click();
        driver.findElement(By.id("exampleFormControlSelect1")).click();
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys(date);
        driver.findElement(By.cssSelector(".btn.btn-success")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert.alert-success")).getText(), "×Success! The Form has been submitted successfully!.");
    }
}

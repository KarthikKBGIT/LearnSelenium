import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UpdatedDropdown {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        for(int i=0;i<5;i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.xpath("//input[@value='Done']")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }
}

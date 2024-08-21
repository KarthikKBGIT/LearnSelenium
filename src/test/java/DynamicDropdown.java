import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DynamicDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        driver.findElement(By.xpath("//div[@id='marketCityPair_1']//select[contains(@id,'originStation')]")).click();
        driver.findElement(By.xpath("//div[@id='marketCityPair_1']//select[contains(@id,'originStation')]//option[@value='BLR']")).click();
        driver.findElement(By.xpath("//div[contains(@id,'destinationStation')]//a[@value='MAA']")).click();

        //CheckBox Handling
        System.out.println(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
        driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).click();
        System.out.println(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
    }
}

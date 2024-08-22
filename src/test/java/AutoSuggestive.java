import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoSuggestive {
    public static void main(String[] arg) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.findElement(By.id("autosuggest")).sendKeys("Ind");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ui-menu-item']/a")));
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        System.out.println(options);
        for(WebElement option: options){
            System.out.println(option.getText());
            if(option.getText().equalsIgnoreCase("India")){
                option.click();
                System.out.println(option.getText());
                break;
            }
        }
    }
}

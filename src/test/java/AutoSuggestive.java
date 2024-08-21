import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestive {
    public static void main(String[] arg) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.findElement(By.id("autosuggest")).sendKeys("Ind");
        Thread.sleep(2000);
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

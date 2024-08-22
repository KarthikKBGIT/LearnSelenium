import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Set;

/*
1. Go to https://rahulshettyacademy.com/AutomationPractice/
2. Get the footer links
3. Open all the links on new tab by using Keys.chord
4. Print the titles of all the child windows
 */

public class KeysAction {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> leftFooterLinks = driver.findElements(By.xpath("//div[@id='gf-BIG']//tr/td[1]//a"));
        String keyStrokesToOpenLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
        for(WebElement leftFooterLink : leftFooterLinks){
            leftFooterLink.sendKeys(keyStrokesToOpenLink);
        }
        Set<String> windows = driver.getWindowHandles();
        for(String window: windows){
            driver.switchTo().window(window);
            System.out.println(driver.getTitle());
            //driver.close();
        }
    }
}

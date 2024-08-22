import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

/*
1. Go to https://rahulshettyacademy.com/AutomationPractice/
2. Scroll the web page window using JavaScriptExecutor
3. Scroll with in table using querySelector in JSExecutor
4. Sum all the amount from the fourth column on that inner table
5. verify is the total amount present on the web page and total amount we calculated is same or not
 */
public class JavaScriptExecutorMethods {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        int total=0;
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        jsExecutor.executeScript("window.scrollTo(0, 750)");
        List<WebElement> numbers = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        for(WebElement number:numbers){
            total += Integer.parseInt(number.getText());
        }
        String[] webText = driver.findElement(By.cssSelector(".totalAmount")).getText().split(" ");
        int totalInWeb = Integer.parseInt(webText[webText.length-1]);
        Assert.assertEquals(total,totalInWeb);
        driver.close();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Assignment4 {
    public static void main(String[] args) {
        /*
        1. Go to https://the-internet.herokuapp.com/
        2. Click "Multiple Windows"
        3. Click "Click Here" link and new window will open.
        4. Get the text from new window and print it.
        5. Go back to parent window. Get the text from parent window and print it
         */
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Click Here']")));
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentID = iterator.next();
        String childID = iterator.next();
        driver.switchTo().window(childID);
        String childWindowText = driver.findElement(By.cssSelector(".example")).getText();
        driver.switchTo().window(parentID);
        String parentWindowText = driver.findElement(By.cssSelector(".example")).getText();
        System.out.println("Child Window Text: " + childWindowText + "\nParent Window Text: " + parentWindowText);
    }
}

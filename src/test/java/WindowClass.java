import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowClass {
    public static void main(String[] args){
        /*
        1. Go to https://rahulshettyacademy.com/loginpagePractise/
        2. Click on the link on top right corner and new child window will be opened
        3. switch to child window and get the mail ID
         */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();
        System.out.println(parentId + " " + childId);
        driver.switchTo().window(childId);
        String text = driver.findElement(By.xpath("//p[contains(@class,'red')]")).getText();
        String emailID = text.split(" ")[4];
        System.out.println(emailID);
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(emailID);
    }
}

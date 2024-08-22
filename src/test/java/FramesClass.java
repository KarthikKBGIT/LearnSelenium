import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
1. Go to https://jqueryui.com/droppable/
2. Switch control to the iFrame
3. Drag "Drag me to my target" element and drop it on "Drop here"
4. Switch back to main page
5. Click "Accept"
 */

public class FramesClass {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement,targetElement);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Accept']")).click();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.Random;

/*
1. Go to https://rahulshettyacademy.com/AutomationPractice/
2. Select any check box and then grab the label of the selected checkbox
3. Select same option on dropdown
4. Enter the same label text on EditBox.
5. Click Alert and verify the text graped from step 2 is presented on pop up message
6. Click Ok on Alert
 */
public class Assignment6 {
    public static void main(String[] args) {
        Random random = new Random();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        int optionIndex = random.nextInt(0, 1000) % 3;
        driver.findElement(By.xpath("//input[@id='checkBoxOption"+(optionIndex+1)+"']" )).click();
        String selectionOptionText = driver.findElement(By.xpath("//input[@id='checkBoxOption"+(optionIndex+1)+"']/parent::label")).getText();
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
        dropdown.click();
        Select select = new Select(dropdown);
        select.selectByIndex(optionIndex);
        driver.findElement(By.xpath("//select[@id='dropdown-class-example']/option[@value='"+selectionOptionText.toLowerCase()+"']"));
        driver.findElement(By.cssSelector("#name")).sendKeys(selectionOptionText);
        driver.findElement(By.cssSelector("#alertbtn")).click();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains(selectionOptionText));
        driver.switchTo().alert().accept();
    }
}

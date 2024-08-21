import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assesment1 {
    public static void main(String[] args){
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //Navigate to: https://rahulshettyacademy.com/AutomationPractice/
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //Check the first  Checkbox and verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked
        driver.findElement(By.xpath("//input[@type='checkbox' and @value='option1']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='checkbox' and @value='option1']")).isSelected());
        driver.findElement(By.xpath("//input[@type='checkbox' and @value='option1']")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//input[@type='checkbox' and @value='option1']")).isSelected());
        //How to get the Count of number of check boxes present in the page
        Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(),3);
    }
}

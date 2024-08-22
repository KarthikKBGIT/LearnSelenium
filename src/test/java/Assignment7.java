import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/*
1. Go to https://www.qaclickacademy.com/practice.php
2. Print no of rows in the table
3. Print no of columns in the table
4. Print 2nd row values in the table
 */
public class Assignment7 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        driver.get("https://www.qaclickacademy.com/practice.php");
        jsExecutor.executeScript("window.scrollTo(0, 500)");
        int noOfRows = driver.findElements(By.cssSelector(".table-display tr")).size();
        int noOfColumns = driver.findElements(By.cssSelector(".table-display tr th")).size();
        List<WebElement> values = driver.findElements(By.xpath("//*[@class='table-display']//tr[3]/td"));

        System.out.println("No of Rows: " + noOfRows);
        System.out.println("No of Columns: " + noOfColumns);
        System.out.println("Values in 2nd Row:");
        for(WebElement value: values){
            System.out.println(value.getText());
        }
    }
}

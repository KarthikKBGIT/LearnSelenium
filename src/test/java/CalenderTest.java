import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/*
1. Go to https://rahulshettyacademy.com/seleniumPractise/#/offers
2. Click the calendar and select the date by navigating to given date
3. Get the date from the calendar text box and compare it with what we provided during initialisation.
 */
public class CalenderTest {
    public static void main(String[] args){
        String date="10", monthNumber="3", year="2027";
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(".react-date-picker")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
        driver.findElement(By.xpath("//button/abbr[text()='"+date+"']")).click();
        String calendarDate = driver.findElement(By.xpath("//input[@name='day']")).getAttribute("value");
        String calendarMonth = driver.findElement(By.xpath("//input[@name='month']")).getAttribute("value");
        String calendarYear = driver.findElement(By.xpath("//input[@name='year']")).getAttribute("value");
        Assert.assertEquals(date, calendarDate);
        Assert.assertEquals(monthNumber, calendarMonth);
        Assert.assertEquals(year, calendarYear);
        driver.close();
    }
}

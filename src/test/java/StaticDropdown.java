import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement staticDropdown = driver.findElement(By.xpath("//div[contains(@class,'currency')]/select[contains(@id,'Currency')]"));
        Select selectObject = new Select(staticDropdown);
        selectObject.selectByIndex(1);
        System.out.println(selectObject.getFirstSelectedOption().getText());
        selectObject.selectByValue("AED");
        System.out.println(selectObject.getFirstSelectedOption().getText());
        selectObject.selectByVisibleText("USD");
        System.out.println(selectObject.getFirstSelectedOption().getText());
    }
}

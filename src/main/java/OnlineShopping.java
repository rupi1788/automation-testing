import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlineShopping {

    public static void getBrowserPage(String s){
        ChromeDriver driver = new ChromeDriver();
        driver.get(s);
        driver.findElement(By.cssSelector("[name = 'q']"));
        WebElement x = driver.findElement(By.cssSelector("[name='q']"));
        x.sendKeys("abc");
        System.out.println("abc");

    }
    public static void main(String[]args){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        getBrowserPage("http://www.google.com");

}





}

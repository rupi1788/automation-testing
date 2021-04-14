import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homepage {
    ChromeDriver driver = new ChromeDriver();

      // for search option;
    public CustomerPage search(CharSequence searchItem) {
        WebElement e = driver.findElement(By.id("twotabsearchtextbox"));
        e.click();

        e.sendKeys(searchItem);
        driver.findElement(By.id("nav-search-submit-button"));
        e.submit();

        CustomerPage customerPage = new CustomerPage();
        return customerPage;
    }


    // for sign-in option;
    public CustomerPage signIn(CharSequence email,CharSequence password){
        WebElement e = driver.findElement(By.id("nav-link-accountList"));
        driver.findElement(By.className("nav-action-button"));
        e.click();

        e = driver.findElement(By.name("email"));
        e.sendKeys(email);
        e = driver.findElement(By.id("continue"));
        e.click();

        e = driver.findElement(By.name("password"));
        e.sendKeys(password);
        e = driver.findElement(By.id("signInSubmit"));
        e.click();

        CustomerPage customerPage = new CustomerPage();
        return customerPage;
    }


       //        for new user register;
    public CustomerPage newUserRegister(CharSequence name, CharSequence email, CharSequence password){
        WebElement e = driver.findElement(By.id("nav-link-accountList"));
        driver.findElement(By.className("nav-action-button"));
        e.click();
        e= driver.findElement(By.id("createAccountSubmit"));
        e.click();

        e= driver.findElement(By.id("ap_customer_name"));
        e.sendKeys(name);

        e= driver.findElement(By.id("ap_email"));
        e.sendKeys(email);

        e= driver.findElement(By.id("ap_password"));
        e.sendKeys(password);

        e= driver.findElement(By.id("ap_password_check"));
        e.sendKeys(password);

        e= driver.findElement(By.id("continue"));
        e.click();

        CustomerPage customerPage = new CustomerPage();
        customerPage.driver = this.driver;
        return customerPage;
   }

   public void navigate() {
       driver.get("http://www.amazon.com");
   }

    public static void main(String[]args) {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");

        Homepage homepage = new Homepage();
        homepage.navigate();
        homepage.signIn("abc@gmail.com", "12345678");
        //homepage.newUserRegister("abcd","abc@gmail.com","12345678");
        //homepage.search("toys");
    }
}

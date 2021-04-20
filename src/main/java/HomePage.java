import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
    WebDriver driver= new ChromeDriver();

    public String navigateToUrlAndGetTitle(String url) {
        driver.get(url);
        String title= driver.getTitle();
        return title;

    }

    // for search option;
    public String searchAnItemToGetContentPageTitle(CharSequence searchItem) {
        WebElement e = driver.findElement(By.id("twotabsearchtextbox"));
        e.click();

        e.sendKeys(searchItem);
        driver.findElement(By.id("nav-search-submit-button"));
        e.submit();

        ContentPage contentPage = new ContentPage();
        contentPage.driver = this.driver;
        String contentPageTitle = driver.getTitle();

        return contentPageTitle;
    }


    // for sign-in option;
    public String signIn(CharSequence email, CharSequence password) {
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
        CustomerPage.driver = this.driver;
        String customerPageTitle= driver.getTitle();
        return customerPageTitle;
    }


    //        for new user register;
    public CustomerPage newUserRegister(CharSequence name, CharSequence email, CharSequence password) {
        WebElement e = driver.findElement(By.id("nav-link-accountList"));
        driver.findElement(By.className("nav-action-button"));
        e.click();
        e = driver.findElement(By.id("createAccountSubmit"));
        e.click();

        e = driver.findElement(By.id("ap_customer_name"));
        e.sendKeys(name);

        e = driver.findElement(By.id("ap_email"));
        e.sendKeys(email);

        e = driver.findElement(By.id("ap_password"));
        e.sendKeys(password);

        e = driver.findElement(By.id("ap_password_check"));
        e.sendKeys(password);

        e = driver.findElement(By.id("continue"));
        e.click();

        CustomerPage customerPage = new CustomerPage();
        customerPage.driver = this.driver;
        return customerPage;
    }
}

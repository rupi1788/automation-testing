import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class HomePageTest {
    //WebDriver driver;

    public void testToNavigateUrlAndGetTitle(){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
       // driver = new ChromeDriver();
        HomePage homePage = new HomePage();
        String title = homePage.navigateToUrlAndGetTitle("http://www.amazon.com");
        //driver.get("http://www.amazon.com");
        String actualTitle= title;
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        Assert.assertEquals(actualTitle,expectedTitle,"Amazon home page title.");
    }

    public void testSearchTab() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        // driver = new ChromeDriver();
        HomePage homePage = new HomePage();
        homePage.navigateToUrlAndGetTitle("http://www.amazon.com");
        String title = homePage.searchAnItemToGetContentPageTitle("furniture");
        String actualTitle = title;
        String expectedTitle = "Amazon.com : furniture";
        Assert.assertEquals(actualTitle,expectedTitle,"Title for furniture page.");
    }
    public void testSignInTab() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        // driver = new ChromeDriver();
        HomePage homePage = new HomePage();
        homePage.navigateToUrlAndGetTitle("http://www.amazon.com");
        String title = homePage.signIn("grupika17@gmail.com","R12345678");
        String actualTitle = title;
        String expectedTitle ="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        Assert.assertEquals(actualTitle,expectedTitle,"Title for customer page.");
    }
}
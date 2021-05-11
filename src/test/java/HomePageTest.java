import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest {
    WebDriver driver;

    @Test
    public void testToNavigateUrlAndGetTitle(){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.amazon.com");

        HomePage homePage = new HomePage();
        homePage.driver = this.driver;
        String title = homePage.navigateToUrlAndGetTitle("http://www.amazon.com");
        String title1 = driver.getTitle();

        String actualTitle= title1;
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        Assert.assertEquals(actualTitle,expectedTitle,"Amazon home page title.");
    }

    @Test
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

    @Test
    public void testSignInTab() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        HomePage homePage = new HomePage();
        homePage.navigateToUrlAndGetTitle("http://www.amazon.com");
       boolean result =  homePage.signIn("grupika17@gmail.com","R12345678");
        //String title = homePage.signIn("grupika17@gmail.com","R12345678");
        //String actualTitle = title;
       // String expectedTitle ="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        //Assert.assertEquals(actualTitle,expectedTitle,"Title for customer page.");
        boolean actualResult = result;
        boolean expectedResult = true;
        Assert.assertEquals(actualResult,expectedResult, "Hello, Rupika is displayed");

    }

    @Test
    public void testForNewUserRegistrationFlowWhereUserNameNull(){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        HomePage homePage = new HomePage();
        homePage.navigateToUrlAndGetTitle("http://www.amazon.com");
        boolean result = homePage.newUserRegisterationFlow("","a1b2c3d4@gmail.com","12345678");
        boolean actualResult = result;
        boolean expectedResult = true;
        Assert.assertEquals(actualResult,expectedResult, "Enter your name");
    }

    @Test
    public void testForNewUserRegistrationFlowWhereUserEmailNull(){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        HomePage homePage = new HomePage();
        homePage.navigateToUrlAndGetTitle("http://www.amazon.com");
        boolean result = homePage.newUserRegisterationFlow("abcd","","12345678");
        boolean actualResult = result;
        boolean expectedResult = true;
        Assert.assertEquals(actualResult,expectedResult, "Enter your email");
    }


    @Test
    public void testForNewUserRegistrationFlowWhereUserPasswordNull(){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        HomePage homePage = new HomePage();
        homePage.navigateToUrlAndGetTitle("http://www.amazon.com");
        boolean result = homePage.newUserRegisterationFlow("abcd","a1b2c3d4@gmail.com","");
        boolean actualResult = result;
        boolean expectedResult = true;
        Assert.assertEquals(actualResult,expectedResult, "Enter your password");
    }

    @Test
    public void testForNewUserRegistrationFlow(){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        HomePage homePage = new HomePage();
        homePage.navigateToUrlAndGetTitle("http://www.amazon.com");
        boolean result = homePage.newUserRegisterationFlow("garima","garima.amirag12@gmail.com","garima12");
        boolean actualResult = result;
        boolean expectedResult = true;
        Assert.assertEquals(actualResult,expectedResult, "otp required is displayed");
    }
}
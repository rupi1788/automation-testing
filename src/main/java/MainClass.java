

public class MainClass {


    public static void main(String[]args) {

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        HomePage homePage = new HomePage();
        homePage.navigateToUrlAndGetTitle("http://www.amazon.com");
        homePage.signIn("grupika17@gmail.com", "R12345678");
        //homepage.newUserRegister("abcd","abc@gmail.com","12345678");
       // homePage.searchAnItemToGetContentPageTitle("furniture");
    }
}

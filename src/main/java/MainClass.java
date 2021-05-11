

public class MainClass {


    public static void main(String[]args) {

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        HomePage homePage = new HomePage();
        homePage.navigateToUrlAndGetTitle("http://www.amazon.com");
        boolean result = homePage.signIn("grupika17@gmail.com", "R12345678");
        //System.out.println(result);
        //boolean result = homePage.newUserRegisterationFlow("Garima","garima.amirag123@gmail.com","12341234");
        //System.out.println(result);

       // homePage.searchAnItemToGetContentPageTitle("furniture");
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    WebDriver driver;

    public String navigateToUrlAndGetTitle(String url) {
        // driver.get(url);
        String title = driver.getTitle();
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
    public boolean signIn(CharSequence email, CharSequence password) {
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
        boolean customer = driver.findElement(By.id("nav-link-accountList-nav-line-1")).isDisplayed();

        CustomerPage customerPage = new CustomerPage();
        customerPage.driver = this.driver;
        //String customerPageTitle= driver.getTitle();
        //return customerPageTitle;
        return customer;
    }


    //        for new user register;
    public boolean newUserRegisterationFlow(CharSequence name, CharSequence email, CharSequence password) {
        WebElement signInTab = driver.findElement(By.id("nav-link-accountList"));
        driver.findElement(By.className("nav-action-button"));
        signInTab.click();
        WebElement createAccount = driver.findElement(By.id("createAccountSubmit"));
        createAccount.click();

        WebElement yourNameTab = driver.findElement(By.id("ap_customer_name"));
        yourNameTab.sendKeys(name);


        WebElement emailTab = driver.findElement(By.id("ap_email"));
        emailTab.sendKeys(email);

        WebElement passwordTab = driver.findElement(By.id("ap_password"));
        passwordTab.sendKeys(password);

        WebElement reEnterPasswordTab= driver.findElement(By.id("ap_password_check"));
        reEnterPasswordTab.sendKeys(password);

        WebElement createYourAmazonAccountTab = driver.findElement(By.id("continue"));
        createYourAmazonAccountTab.click();

        boolean result = true;
        if (name == "" || email == "" || password == "") {
            List<WebElement> listOfWebElementsAsPerClass = driver.findElements(By.className("a-alert-content"));
            List<WebElement> alert = driver.findElements(By.className("a-alert-content"));

            for (WebElement webElement : listOfWebElementsAsPerClass) {
                String alertText = webElement.getText();
                System.out.println(alertText);
                if ((alertText == "Enter your name") || (alertText == "Enter your email") || (alertText == "Enter your password")) {
                    return true;
                }
            }

        }
        if (name != "" && email != "" && password != "") {
            result = driver.findElement(By.id("cvf-input-code")).isDisplayed();
            if (result == true) {
                System.out.println("otp required is displayed");
                return true;
            }

        }

        return true;
    }
}



//    public static void main1(String[] args) {
//        List<Integer> myList = Arrays.asList(1, 2, 3, 4,5);
//        for (int i = 0; i < myList.size(); i++) {
//            System.out.println(myList.get(i));
//        }
//
//        for (Integer x : myList) {
//            System.out.println(x);
//        }


//    }
//}

//            result = driver.findElement(By.className("a-alert-content")).isDisplayed();
//            if (result == true) {
//                System.out.println("error is displayed");
//            } else {
//                result = false;
//                System.out.println("error is not displayed");
//            }
//            return result;
 //       }

//        if (name != "" && email != "" && password != "") {
//            result = driver.findElement(By.id("cvf-input-code")).isDisplayed();
//            if (result == true) {
//                System.out.println("otp required is displayed");
//            } else {
//                result = false;
//                System.out.println("otp required is not displayed");
//            }
//        }
//        return result;
//    }
//}

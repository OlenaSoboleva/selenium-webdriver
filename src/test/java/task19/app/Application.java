package task19.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import task19.pages.CartPage;
import task19.pages.CustomerSitePage;
import task19.pages.GoodPage;

import java.util.concurrent.TimeUnit;

public class Application{
    private WebDriver driver;
    private WebDriverWait wait;

    private CustomerSitePage customerSitePage;
    private GoodPage goodPage;
    private CartPage cartPage;


    public Application(){
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver,10);
        customerSitePage= new CustomerSitePage(driver);
        goodPage=new GoodPage(driver);
        cartPage=new CartPage(driver);
    }

    public void quit(){driver.quit();}

    public static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return driver.findElements(locator).size() > 0;
        } finally {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        }
    }

    public void addGoodsToCart(){
        for (int i = 0; i < 3; i++) {
            customerSitePage.open();
            customerSitePage.isOnCustomerSitePage();
            customerSitePage.openGood();
            goodPage.isOnGoodPage();
            goodPage.addToCart("Small");
            goodPage.checkUpdatedCart();
        }

    }

    public void deleteFromCart(){
        goodPage.openCart();
        cartPage.removeFromCart();
    }
}

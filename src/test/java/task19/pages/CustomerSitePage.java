package task19.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static task19.app.Application.isElementPresent;


public class CustomerSitePage extends Page {
    public CustomerSitePage(WebDriver driver) {
        super(driver);
    }

    public CustomerSitePage open() {
        driver.navigate().to(siteLink);
        return this;
    }

    public boolean isOnCustomerSitePage() {
        String locator = "div#box-campaigns.box [class=link]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
        return isElementPresent(driver, By.cssSelector(locator));
    }

    public void openGood() {
        driver.findElements(By.cssSelector("div#box-most-popular.box [class=link]")).get(0).click();
    }
}

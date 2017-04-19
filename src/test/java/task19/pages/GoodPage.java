package task19.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static task19.app.Application.isElementPresent;


public class GoodPage extends Page {
    public GoodPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnGoodPage() {
        String locator = "button[name*=add_cart_product]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
        return isElementPresent(driver, By.cssSelector(locator));
    }

    public void addToCart(String small) {
        if (driver.findElements(By.cssSelector("select[name*=options]")).size() > 0) {
            Select size = new Select(driver.findElement(By.cssSelector("select[name*=options]")));
            size.selectByVisibleText(small);
        }
        driver.findElement(By.cssSelector("button[name*=add_cart_product]")).click();
    }

    public void checkUpdatedCart() {
        int count = 0;
        count = Integer.parseInt(driver.findElement(By.cssSelector("span.quantity")).getText());
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector("span.quantity")), String.valueOf(count + 1)));
    }

    public void openCart() {
        driver.findElement(By.cssSelector("span.quantity")).click();
    }

}

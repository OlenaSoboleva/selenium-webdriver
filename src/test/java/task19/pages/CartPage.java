package task19.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends Page {
    public CartPage(WebDriver driver) {
        super(driver);
    }
//    @FindBy(css = ".dataTable.rounded-corners")
//    public WebElement table;
//
//    @FindBy(css = "td.item")
//    public  List<WebElement> tableRowsCount;

//    @FindBy(css = "button[name*=remove_cart_item]")
//    public WebElement buttonRemoveFromCart;

    public void removeFromCart() {
        int tablecountsize = driver.findElements(By.cssSelector("td.item")).size();
        for (int i = 0; i < tablecountsize; i++) {
            driver.findElement(By.cssSelector("button[name*=remove_cart_item]")).click();
//            buttonRemoveFromCart.click();
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector(".dataTable.rounded-corners")))));
        }
    }
}

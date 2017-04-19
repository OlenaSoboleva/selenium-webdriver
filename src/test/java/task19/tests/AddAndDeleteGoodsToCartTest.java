package task19.tests;


import org.junit.Test;


public class AddAndDeleteGoodsToCartTest extends TestBase {
    @Test
    public void addAndDeleteGoods() {
        app.addGoodsToCart();
        app.deleteFromCart();
    }
}
package solvd.carina.BDD.saucedemo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.springframework.core.annotation.Order;
import solvd.carina.BDD.db.models.Orders;

public class ProductPage extends AbstractPage {
    @FindBy(xpath = "//*[contains(text(),'%s')]/../../..//button")
    private ExtendedWebElement product;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private ExtendedWebElement cartLink;
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartLinkPresent(){
        return cartLink.isElementPresent();
    }
    public CartPage clickCartLink(){
        cartLink.click();
        return new CartPage(getDriver());
    }
    public void addProductToCart(Orders order){
        product.format(order.getProductName()).scrollTo();
        product.format(order.getProductName()).click();
    }

}
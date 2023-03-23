package solvd.carina.BDD.saucedemo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='inventory_item_name'][contains(text(),'%s')]")
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

}
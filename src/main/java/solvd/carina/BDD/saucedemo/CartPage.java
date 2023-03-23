package solvd.carina.BDD.saucedemo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {
    @FindBy(xpath = "//button[@id='checkout']")
    private ExtendedWebElement checkoutBtn;
    @FindBy(xpath = "//input[@id='continue']")
    private ExtendedWebElement continueBtn;
    @FindBy(xpath = "//button[@id='finish']")
    private ExtendedWebElement finishBtn;
    @FindBy(xpath = "//input[@id='first-name']")
    private ExtendedWebElement firstNameField;
    @FindBy(xpath = "//input[@id='last-name']")
    private ExtendedWebElement lastNameField;
    @FindBy(xpath = "//input[@id='postal-code']")
    private ExtendedWebElement zipCodeField;
    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private ExtendedWebElement totalPriceLabel;
    public CartPage(WebDriver driver) {
        super(driver);
    }
}
package solvd.carina.BDD.saucedemo;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//input[@id='user-name']")
    private ExtendedWebElement loginField;

    @FindBy(xpath = "//input[@id='password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//input[@id='login-button']")
    private ExtendedWebElement loginBtn;
    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/");
    }

    public boolean isLoginFieldPresent(){
        return loginField.isElementPresent();
    }
    public boolean isPasswordFieldPresent(){
        return passwordField.isElementPresent();
    }
    public boolean isLoginBtnPresent(){
        return loginBtn.isElementPresent();
    }
    public void clickLogin(){
        loginBtn.click();
    }
    public void typeLogin(String login){
        loginField.type(login);
    }
    public void typePassword(String password){
        passwordField.type(password);
    }
}
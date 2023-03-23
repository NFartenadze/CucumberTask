package solvd.carina.BDD.cucumber.steps;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import solvd.carina.BDD.db.dao.OrdersDAO;
import solvd.carina.BDD.db.dao.UserDAO;
import solvd.carina.BDD.db.mappers.OrdersMapper;
import solvd.carina.BDD.db.mappers.UserMapper;
import solvd.carina.BDD.saucedemo.CartPage;
import solvd.carina.BDD.saucedemo.LoginPage;
import solvd.carina.BDD.saucedemo.ProductPage;

public class SauceDemoSteps extends CucumberRunner {
    UserMapper userService = new UserDAO();
    OrdersMapper ordersService = new OrdersDAO();
    LoginPage loginPage = null;
    ProductPage productPage = null;
    CartPage cartPage = null;

    @Given("I am on login page")
    public boolean iAmOnLoginPage(){
        loginPage = new LoginPage(getDriver());
        loginPage.open();
        return loginPage.isPageOpened();
    }

    @When("I login, product page loads")
    public void iOpenProductPage(){
        loginPage.typeLogin(userService.getUserById(1).getUsername());
        loginPage.typePassword(userService.getUserById(1).getPassword());
        productPage = loginPage.clickLogin();
    }

    @Then("I add user's products to cart")
    public void iAddUsersProductsToCart(){
        ordersService.getAllOrdersByUserId(1)
                .forEach(order -> productPage.addProductToCart(order));
    }

    @Then("I open cart page")
    public void iOpenCartPage(){
        Assert.assertTrue(productPage.isCartLinkPresent(),"cart link isn't present");
        cartPage = productPage.clickCartLink();
    }

    @And("I checkout user's orders")
    public void iCheckoutUsersOrders(){
        Assert.assertTrue(cartPage.isCheckoutBtnPresent(),"Checkout Button isn't present");
        cartPage.clickCheckoutBtn();
        Assert.assertTrue(cartPage.isFirstNameFieldPresent(),"First name field isn't present");
        cartPage.typeFirstName("Example");
        Assert.assertTrue(cartPage.isLastNameFieldPresent(),"Last name field isn't present");
        cartPage.typeLastName("Example");
        Assert.assertTrue(cartPage.isZipCodeFieldPresent(),"Zip code field isn't present");
        cartPage.typeZipCode("12345");
        Assert.assertTrue(cartPage.isContinueBtnPresent(),"Continue button isn't present");
        cartPage.clickContinueBtn();
        Assert.assertTrue(cartPage.isFinishBtnPresent(),"Finish button isn't present");
        cartPage.clickFinishBtn();
    }
}
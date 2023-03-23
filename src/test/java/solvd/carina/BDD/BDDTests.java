package solvd.carina.BDD;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.springframework.core.annotation.Order;
import org.testng.Assert;
import org.testng.annotations.Test;
import solvd.carina.BDD.db.dao.OrdersDAO;
import solvd.carina.BDD.db.dao.UserDAO;
import solvd.carina.BDD.db.mappers.OrdersMapper;
import solvd.carina.BDD.db.mappers.UserMapper;
import solvd.carina.BDD.db.models.Orders;
import solvd.carina.BDD.db.models.User;
import solvd.carina.BDD.saucedemo.CartPage;
import solvd.carina.BDD.saucedemo.LoginPage;
import solvd.carina.BDD.saucedemo.ProductPage;

import java.util.List;


public class BDDTests implements IAbstractTest {

    @Test
    public void getorders(){
        UserMapper userService = new UserDAO();
        User user = userService.getUserById(1);
        OrdersMapper ordersService = new OrdersDAO();
        List<Orders> userOrders =  ordersService.getAllOrdersByUserId(1);
    }
    @Test
    public void checkOutItems(){
        UserMapper userService = new UserDAO();
        OrdersMapper ordersService = new OrdersDAO();
        User user = userService.getUserById(1);
        List<Orders> userOrders =  ordersService.getAllOrdersByUserId(user.getId());

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(),"Login page isn't opened");
        Assert.assertTrue(loginPage.isLoginFieldPresent(),"Login field isn't present");
        loginPage.typeLogin(user.getUsername());
        Assert.assertTrue(loginPage.isPasswordFieldPresent(),"Password field isn't present");
        loginPage.typePassword(user.getPassword());
        Assert.assertTrue(loginPage.isLoginBtnPresent(),"Login button isn't present");
        loginPage.clickLogin();

        ProductPage productPage = new ProductPage(getDriver());
        userOrders.forEach(order -> productPage.addProductToCart(order));
        Assert.assertTrue(productPage.isCartLinkPresent(),"Cart Link isn't present");

        CartPage cartPage = new CartPage(getDriver());
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
package solvd.carina.BDD;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.springframework.core.annotation.Order;
import org.testng.Assert;
import org.testng.annotations.Test;
import solvd.carina.BDD.db.dao.OrdersDAO;
import solvd.carina.BDD.db.dao.UserDAO;
import solvd.carina.BDD.db.models.Orders;
import solvd.carina.BDD.db.models.User;
import solvd.carina.BDD.saucedemo.LoginPage;


public class BDDTests implements IAbstractTest {

    @Test
    public void createUser() {
//        UserDAO userService = new UserDAO();
//        userService.getAllUsers().forEach(e -> System.out.println(e.getUsername()));
        OrdersDAO orderService = new OrdersDAO();
        orderService.insertOrder(new Orders(4l,"Sauce Labs Onesie",7.99));
    }

    @Test
    public void testing(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(),"Login page isn't opened");
        Assert.assertTrue(loginPage.isLoginFieldPresent(),"Login field isn't present");
        loginPage.typeLogin("standard_user");
        Assert.assertTrue(loginPage.isPasswordFieldPresent(),"Password field isn't present");
        loginPage.typePassword("secret_sauce");
        Assert.assertTrue(loginPage.isLoginBtnPresent(),"Login button isn't present");

    }
}
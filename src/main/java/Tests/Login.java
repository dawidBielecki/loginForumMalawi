package Tests;

import DataPacked.DataLogin;
import DataPacked.DefaultTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Login extends DefaultTest {

    private WebElement loginButton, emailField, passwordField, buttonField, logOutButton;

    DataLogin dataLogin = new DataLogin();

    @BeforeMethod
    public void beforeMethod(){
        loginButton = driver.findElement(By.id("elUserSignIn"));
        emailField = driver.findElement(By.name("auth"));
        passwordField = driver.findElement(By.name("password"));
        buttonField = driver.findElement(By.id("elSignIn_submit"));
        //logOutButton = driver.findElement(By.linkText("Wyloguj"));

    }


    @AfterMethod
    public void afterMethod(){
        //aronol

    }

    @Test(priority = 1)
    public void login(){

        loginButton.click();
        emailField.sendKeys(dataLogin. login);
        passwordField.sendKeys(dataLogin. password);
        buttonField.click();

        assertEquals(driver.getTitle(), dataLogin.titleOfSite);

        System.out.println("Test 1 OK! Login correct");

        //wylogowanie z poprzedniej sesji
        driver.findElement(By.id("elUserLink")).click();
        driver.findElement(By.linkText("Wyloguj")).click();
        //System.out.println("Wylogowano z testu nr1");
    }

    @Test(priority = 2)
    public void wrongPassword(){


        loginButton.click();
        emailField.sendKeys(dataLogin. login);
        passwordField.sendKeys(dataLogin. wrongPassword);
        buttonField.click();

        assertEquals(driver.getCurrentUrl(), dataLogin.currentUrl);

        System.out.println("Test 2 OK. Login failed - wrong password");

        driver.navigate().back();

    }

    @Test(priority = 3)
    public void wrongLogin(){

        loginButton.click();
        emailField.sendKeys(dataLogin. wrongLogin);
        passwordField.sendKeys(dataLogin. password);
        buttonField.click();

        assertEquals(driver.getCurrentUrl(), dataLogin.currentUrl);
        System.out.println("Test 3 OK. Login failed - wrong login");
    }



    //Forum - forum.klub-malawi.pl
}














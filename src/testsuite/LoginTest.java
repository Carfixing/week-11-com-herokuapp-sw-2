package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup(){

        openBrowser(baseUrl);
    }
    @Test
    //userSholdLoginSuccessfullyWithValidCredentials
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        // Enter user name
        //to find the element give the value of id
        WebElement userField = driver.findElement(By.id("username"));
        //sending username  to username field element
        userField.sendKeys("tomsmith");

        //Enter Password
        //find the password field element
        WebElement passwordField = driver.findElement(By.name("password"));
        //sending password to password field element
        passwordField.sendKeys("SuperSecretPassword!");

        //Click on Login button
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();

        //Verify the text “Secure Area”
        WebElement secureArea = driver.findElement(By.xpath("//div[@class='example']//h2"));
        System.out.println(secureArea.getText());
        //Verify the text “Secure Area”
        Assert.assertEquals("Incorrect Login detail", "Secure Area", secureArea.getText());
    }

        @Test
         // verifyTheUsernameErrorMessage
        public void  verifyTheUsernameErrorMessage(){
            //Enter “tomsmith1” username
            WebElement userField1 = driver.findElement(By.id("username"));
            //sending username  to username field element
            userField1.sendKeys("tomsmith1");

            //find the password field element
            WebElement passwordField = driver.findElement(By.name("password"));
            //sending password to password field element
            passwordField.sendKeys("SuperSecretPassword!");

            //Click on Login button
            WebElement loginButton = driver.findElement(By.className("radius"));
            loginButton.click();

           //Verify the error message “Your username is invalid!
            WebElement secureArea = driver.findElement(By.id("flash"));
            System.out.println(secureArea.getText());
            Assert.assertEquals("Incorrect Login detail", "Your username is invalid!\n×", secureArea.getText());
        }

        @Test
    public void verifyThePasswordErrorMessage(){
            //Enter “tomsmith1” username
            WebElement userField1 = driver.findElement(By.id("username"));
            //sending username  to username field element
            userField1.sendKeys("tomsmith");

            //find the password field element
            WebElement passwordField = driver.findElement(By.name("password"));
            //sending password to password field element
            passwordField.sendKeys("SuperSecretPassword");

            //Click on Login button
            WebElement loginButton = driver.findElement(By.className("radius"));
            loginButton.click();

            //Verify the error message “Your password is invalid!
            WebElement secureArea = driver.findElement(By.id("flash"));
            System.out.println(secureArea.getText());
            Assert.assertEquals("Incorrect Login detail", "Your password is invalid!\n×", secureArea.getText());
        }
    }



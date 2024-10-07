package testrunner;

import config.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import java.time.Duration;

public class RegistrationTestRunner extends Setup {
    @Test
    public void userRegistration() throws InterruptedException {
        RegistrationPage userReg=new RegistrationPage(driver);
        userReg.btnRegister.click();
        String firstname="Test";
        String lastname="User 14";
        String email="testuser14@test.com";
        String password="1234";
        String phonenumber="01504454778";
        String address="Gulshan, Dhaka";
        userReg.doRegistration(firstname,lastname,email,password,phonenumber,address);

        Thread.sleep(1000);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast")));
        String successMessageActual= driver.findElement(By.className("Toastify__toast")).getText();
        String successMessageExpected="successfully";
        System.out.println(successMessageActual);
        Assert.assertTrue(successMessageActual.contains(successMessageExpected));
    }
}

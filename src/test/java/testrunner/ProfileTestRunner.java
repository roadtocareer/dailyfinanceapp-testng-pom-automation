package testrunner;

import config.Setup;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

import java.io.IOException;

public class ProfileTestRunner extends Setup {
    //@Test(priority = 1)
    public void doLogin() throws IOException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin("salman@test.com","1234");
        Utils.getToken(driver);
    }
    @BeforeTest
    public void setToken() throws ParseException, IOException, InterruptedException {
        Utils.setAuth(driver);
    }
    @Test(priority = 2)
    public void seeProfile(){
        driver.get("https://dailyfinance.roadtocareer.net/user");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.btnProfileIcon.click();
        loginPage.btnProfileMenuItems.get(0).click();
    }
}

package testrunner;

import config.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class DashboardTestRunner extends Setup {
    @BeforeTest
    public void doLogin() throws IOException, ParseException {
        LoginPage loginPage=new LoginPage(driver);
        JSONParser parser=new JSONParser();
        JSONArray jsonArray= (JSONArray) parser.parse(new FileReader("./src/test/resources/users.json"));

        JSONObject userObj= (JSONObject) jsonArray.get(jsonArray.size()-1);
        String email= (String) userObj.get("email");
        String password= (String) userObj.get("password");

        if(System.getProperty("username")!=null && System.getProperty("password")!=null){
            loginPage.doLogin(System.getProperty("username"),System.getProperty("password"));
        }
        else{
            loginPage.doLogin(email,password);
        }

    }
    @Test(priority = 1, description = "Add cost for an item")
    public void addCost() throws InterruptedException {
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.btnAddCost.click();
        dashboardPage.addCost("Item 1","50");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}

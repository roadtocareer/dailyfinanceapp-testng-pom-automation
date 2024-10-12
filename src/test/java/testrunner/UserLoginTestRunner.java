package testrunner;

import config.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

import java.io.FileReader;
import java.io.IOException;

public class UserLoginTestRunner extends Setup {
    LoginPage loginPage;
    @Test(priority = 1, description = "User can login with correct creds")
    public void userLogin() throws ParseException, IOException {
        loginPage=new LoginPage(driver);
        JSONParser parser=new JSONParser();
        JSONArray jsonArray= (JSONArray) parser.parse(new FileReader("./src/test/resources/users.json"));

        JSONObject userObj= (JSONObject) jsonArray.get(jsonArray.size()-1);
        String email= (String) userObj.get("email");
        String password= (String) userObj.get("password");

        loginPage.doLogin(email,password);
        Assert.assertTrue(loginPage.btnProfileIcon.isDisplayed());
        Utils.getToken(driver);

    }
}

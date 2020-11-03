package utils.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForIphone {

    public LoginForIphone(){

        // PageFactory.initElements(WebDriver,this);
    }

    @FindBy(id = "inputEmail")
    private WebElement userName;

    @FindBy(id = "inputPassword")
    private WebElement password;



    public void loginIphone(){



    }
}

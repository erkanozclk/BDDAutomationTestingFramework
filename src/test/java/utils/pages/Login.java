package utils.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    public Login(){

      //   PageFactory.initElements(driver,this);
    }

    @FindBy(id = "inputEmail")
    private WebElement userName;

    @FindBy(id = "inputPassword")
    private WebElement password;



    public void loginLibrari(){



    }

}

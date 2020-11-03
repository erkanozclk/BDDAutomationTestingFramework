package utils.ui.implementations;

import utils.pages.LoginForIphone;
import utils.ui.service.Serviceable;

public class IphoneImp implements Serviceable {


    LoginForIphone loginForIphone = new LoginForIphone();
    @Override
    public void firstImp() {
    loginForIphone.loginIphone();
    }

    @Override
    public void secondStep() {

    }


}

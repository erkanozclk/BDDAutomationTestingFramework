package utils.ui;

import utils.pages.LoginForIphone;

public class IphoneImp implements Serviceable{


    LoginForIphone loginForIphone = new LoginForIphone();
    @Override
    public void firstImp() {
    loginForIphone.loginIphone();
    }

    @Override
    public void secondStep() {

    }


}

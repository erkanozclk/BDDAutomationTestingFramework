package utils.ui;


import utils.pages.Login;

public class DesktopImp implements Serviceable {

    Login login = new Login();
    @Override
    public void firstImp() {
        login.loginLibrari();
    }

    @Override
    public void secondStep() {

    }


}

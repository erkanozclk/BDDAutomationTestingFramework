package utils.ui.implementations;


import utils.pages.Login;
import utils.ui.service.Serviceable;

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

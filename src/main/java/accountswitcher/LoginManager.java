package accountswitcher;

import jnautils.User32;
import jnautils.Win32WindowUtils;
import jnautils.WindowLocator;
import org.json.simple.JSONObject;
import shadowclicker.Util;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LoginManager {
    private JSONObject account;
    private LoginTimer timer;
    private Account accountManager = new Account();

    public void login(JSONObject account, int durationInMinutes, int offsetInMinutes){
        this.account = account;
        timer.startTimerFor(durationInMinutes,offsetInMinutes);
    }

    public boolean shouldLogout(){
        return this.timer.shouldLogOut();
    }

    public void check() throws InterruptedException {
        if(account == null) {
            accountManager.readJson();
            account = accountManager.getFirstCanidate();
            performLogin();
            login(account, 120, 5);
        } else if(shouldLogout()) {
            switchAccount();
        }
    }

    public JSONObject getAccount(){
        return account;
    }

    public void switchAccount() throws InterruptedException {
        logout();
        this.account = null;
        Thread.sleep((int)((Math.random() * 20000)+120000));
    }

    public void performLogin() throws InterruptedException {
        Rectangle bounds = WindowLocator.getRect("RuneLite");
        int offsetX = (int)((Math.random() * 10)-5);
        int offsetY = (int)((Math.random() * 10)-5);
        Util.mouseClick(465+bounds.x+ offsetX, 310 + bounds.y + offsetY);
        Thread.sleep((int)((Math.random() * 200)+400));

        System.out.println((String)account.get("username"));

        RobotTyper.type((String)account.get("username"));
        Thread.sleep((int)((Math.random() * 200)+400));

        RobotTyper.type("\n");
        Thread.sleep((int)((Math.random() * 200)+400));

        RobotTyper.type((String)account.get("password"));
        Thread.sleep((int)((Math.random() * 200)+400));

        RobotTyper.type("\n");
        Thread.sleep((int)((Math.random() * 500)+8000));

        Util.mouseClick(358+bounds.x+ offsetX, 360 + bounds.y + offsetY);
        Thread.sleep((int)((Math.random() * 200)+400));
    }

    public void logout() throws InterruptedException {
        Rectangle bounds = WindowLocator.getRect("RuneLite");
        int offsetX = (int)((Math.random() * 10)-5);
        int offsetY = (int)((Math.random() * 10)-5);

        int x = bounds.x + 646 + offsetX;
        int y =  bounds.y + 508 + offsetY;
        Util.mouseClick(x,y);

        Thread.sleep((int)((Math.random() * 200)+400));

        Util.mouseClick(639+bounds.x+offsetX, 455+bounds.y+offsetY);

        Thread.sleep((int)((Math.random() * 200)+400));
    }
}

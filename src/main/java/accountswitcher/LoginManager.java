package accountswitcher;

import jnautils.WindowLocator;
import org.json.simple.JSONObject;
import shadowclicker.Util;

import java.awt.*;

public class LoginManager {
    private JSONObject account;
    private LoginTimer timer = new LoginTimer();
    private AccountLoader accountManager = new AccountLoader();
    private boolean active = true;

    public void login(JSONObject account, int durationInMinutes, int offsetInMinutes){
        this.account = account;
        timer.startTimerFor(durationInMinutes,offsetInMinutes);
    }

    public boolean shouldLogout(){
        return this.timer.shouldLogOut() && active;
    }

    public void check() throws InterruptedException {
        if(account == null) {
            account = getNextAccount();

            if(account != null) {
                performLogin();
                login(account, 30, 5);
            }

        } else if(shouldLogout()) {
            switchAccount();
        }
    }

    public JSONObject getNextAccount(){
        accountManager.readJson();
        account = accountManager.getFirstCanidate();

        if(account == null) {
            throw new RuntimeException("No Suitable Candidate Found");
        }
        return account;
    }

    public JSONObject getAccount(){
        return account;
    }

    public void switchAccount() throws InterruptedException {
        logout();
        if(account != null){
            accountManager.setPlayed(account, true);
            accountManager.updatePlayDate(account);
            this.account = null;
        }
        Thread.sleep((int)((Math.random() * 20000)+120000));

       // Thread.sleep((int)((Math.random() * 10)+2000));
    }

    public void performLogin() throws InterruptedException {
        Rectangle bounds = WindowLocator.getRect("RuneLite");
        int offsetX = (int)((Math.random() * 10)-5);
        int offsetY = (int)((Math.random() * 10)-5);
        Util.mouseClick(465+bounds.x+ offsetX, 310 + bounds.y + offsetY, false);
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

        Util.mouseClick(358+bounds.x+ offsetX, 360 + bounds.y + offsetY, false);
        Thread.sleep((int)((Math.random() * 200)+400));
    }

    public void logout() throws InterruptedException {
        Rectangle bounds = WindowLocator.getRect("RuneLite");
        int offsetX = (int)((Math.random() * 10)-5);
        int offsetY = (int)((Math.random() * 6)-5);

        int x = bounds.x + 646 + offsetX;
        int y =  bounds.y + 508 + offsetY;
        Util.mouseClick(x,y, true);


        // Simple sleep to make sure account isn't in combat anymore
        Thread.sleep((int)((Math.random() * 200)+30000));

        Util.mouseClick(639+bounds.x+offsetX, 455+bounds.y+offsetY, false);

        Thread.sleep((int)((Math.random() * 200)+400));
    }

    public LoginTimer getTimer() {
        return timer;
    }

    public void setAccount(JSONObject account) {
        this.account = account;
    }

    public void setAccountManager(AccountLoader accountManager) {
        this.accountManager = accountManager;
    }

    public boolean shouldTrigger() {
        return account == null || shouldLogout();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

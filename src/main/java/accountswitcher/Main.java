package accountswitcher;

import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Account a = new Account("C:\\Users\\hansv\\IdeaProjects\\ShadowClicker\\src\\main\\java\\accountswitcher\\accounts.JSON");

        //a.readJson();
        //JSONObject obj = a.getFirstCanidate();

        //if(obj != null){
            //System.out.println(obj.get("username"));
           // a.setPlayed(obj,true);
        //}
        //LoginTimer tm = new LoginTimer();
        //tm.startTimerFor( 5,2);

        LoginManager lm = new LoginManager();
        lm.check();
    }
}

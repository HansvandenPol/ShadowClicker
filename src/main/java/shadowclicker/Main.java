package shadowclicker;

import accountswitcher.LoginManager;
import seagullscript.Looper;

import java.util.Scanner;

public class Main{
    private static boolean running = true;
    private static LoginManager loginManager = new LoginManager();
    private static Script script;

    public static void main(String[] args)  throws InterruptedException {
        script = new Looper();
        ScannerManager sm = new ScannerManager();
        sm.open();
        script.setScannerManager(sm);

        while(running){
            //TODO needs to work like an event to prevent onLoop to continue!
            if(loginManager.shouldLogout()) {
                sm.close();
                loginManager.check();
                sm.open();
            }else{
                script.onLoop();
            }
        }

    }
}

package shadowclicker;

import accountswitcher.AccountLoader;
import accountswitcher.LoginManager;
import seagullscript.Looper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;

public class Main{
    private static boolean running = true;
    private static LoginManager loginManager = new LoginManager();
    private static AccountLoader accountLoader = new AccountLoader();
    private static Script script;
    private static Scanner test;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException, IOException {
        script = new Looper();
        ScannerManager sm = new ScannerManager();
        script.setScannerManager(sm);
        accountLoader.resetPlayedStatus();
        while(running){
            if(loginManager.shouldLogout()) {
                loginManager.check();
                // Clear inputStream
               ScannerManager.clear();
            }else{
                script.onLoop();
            }
        }

    }
}

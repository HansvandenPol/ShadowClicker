package seagullscript;

import shadowclicker.ScannerManager;
import shadowclicker.Script;
import shadowclicker.Util;

import java.util.Scanner;

public class Looper extends Script {
    ScannerManager sm;
    Scanner scanner;

    @Override
    public void onLoop() throws InterruptedException {
        sm = getSm();
        scanner = sm.getScanner();
        String stateInfo = "";
        if(scanner != null){
            stateInfo = scanner.nextLine();
        }
        if (stateInfo.contains("click")) {

            int[] pos = getMousePos(stateInfo);
            Util.mouseClick(pos[0], pos[1]);

            Thread.sleep(2000);
        }
        sleep((int) (Math.random() * 10 + 100));

    }

    public static int[] getMousePos(String state) {
        String coords = state.split(",")[1];
        int[] positions = new int[2];

        positions[0] = Integer.parseInt(coords.split(":")[0]);
        positions[1] = Integer.parseInt(coords.split(":")[1]);
        return positions;
    }
}

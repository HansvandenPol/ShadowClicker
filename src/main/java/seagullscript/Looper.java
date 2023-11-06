package seagullscript;

import com.github.joonasvali.naturalmouse.util.FactoryTemplates;
import shadowclicker.ScannerManager;
import shadowclicker.Script;
import shadowclicker.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Looper extends Script {
    BufferedReader scanner = ScannerManager.getScanner();

    public Looper( ) {
        Util.setMouseFactory(FactoryTemplates.createFastGamerMotionFactory());
    }

    @Override
    public void onLoop() throws InterruptedException, IOException {
        String stateInfo = "";
        //scanner = new Scanner(System.in);
        if(scanner.ready()){
            stateInfo = scanner.readLine();
        }
        if (stateInfo.contains("click")) {

            int[] pos = getMousePos(stateInfo);
            Util.mouseClick(pos[0], pos[1], false);

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

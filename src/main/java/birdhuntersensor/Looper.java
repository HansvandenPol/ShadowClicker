package birdhuntersensor;

import com.github.joonasvali.naturalmouse.util.FactoryTemplates;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import shadowclicker.MyGDI32;
import shadowclicker.ScannerManager;
import shadowclicker.Script;
import shadowclicker.Util;

import java.awt.*;
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
        if(scanner.ready()){
            stateInfo = scanner.readLine();
        }

        if(stateInfo.contains("f")){

            int[] pos = getMousePos(stateInfo);
            Util.mouseClick(pos[0], pos[1], false);

            Thread.sleep((int)(Math.random()*200)+4000);

        } else if(stateInfo.contains("c")) {
            int[] pos = getMousePos(stateInfo);
            Util.mouseClick(pos[0], pos[1], false);

            Thread.sleep((int)(Math.random()*200)+4000);

            Util.mouseClick(pos[0], pos[1], false);

            Thread.sleep((int)(Math.random()*200)+2000);

            Util.mouseClick((int)(Math.random()*10)+1696-5, (int)(Math.random()*10)+252-5, false);
            Thread.sleep((int)(Math.random()*200)+6000);

            Util.dropBirdStuff((int)(Math.random()*10)+1734-5, (int)(Math.random()*10)+257-5, (int)(Math.random()*10)+1779-5, (int)(Math.random()*10)+257-5);
            Thread.sleep((int)(Math.random()*200)+2000);
        } else if(stateInfo.contains("d")){
            int[] pos = getMousePos(stateInfo);
            Util.mouseClick(pos[0], pos[1], false);

            Thread.sleep((int)(Math.random()*200)+4000);

            Util.mouseClick(pos[0], pos[1], false);
            Thread.sleep((int)(Math.random()*200)+4000);

            Util.mouseClick((int)(Math.random()*10)+1696-5, (int)(Math.random()*10)+252-5, false);
            Thread.sleep((int)(Math.random()*200)+4000);
        }

    }

    public static int[] getMousePos(String state) {
        String coords = state.split(",")[1];
        int[] positions = new int[2];

        positions[0] = Integer.parseInt(coords.split(":")[0]);
        positions[1] = Integer.parseInt(coords.split(":")[1]);
        return positions;
    }
}


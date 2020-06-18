package chinbot;

import com.github.joonasvali.naturalmouse.api.MouseMotionFactory;
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

    public static void main(String[] args)  throws InterruptedException {
        boolean running = true;
        Util.testColor(110, 176);
        Scanner myObj = new Scanner(System.in);  // Create a Scanner objec

        while(true){


        }


        // gdiTest();s
        //robotTest();

        //Script loadedScript = new WoodCutterTest();

//        while(running)  {
//            loadedScript.onLoop();
//        }
    }

    public static int[] getMousePos(String state) {
        String coords = state.split(",")[1];
        int[] positions = new int[2];

        positions[0] = Integer.parseInt(coords.split(":")[0]);
        positions[1] = Integer.parseInt(coords.split(":")[1]);
        return positions;
    }
    public static void gdiTest(){
        WinDef.HWND hWnd = User32.INSTANCE.FindWindow(null, "Naamloos - Kladblok");
        WinDef.HDC hdcWindow = User32.INSTANCE.GetDC(null);
        int col = 0xA0863E;
        for(int i = 1 ; i < 200; i+=4) {
            for (int j = 1; j< 200; j+=4){
                int a = MyGDI32.INSTANCE.GetPixel(hdcWindow, i,j);
                if(a == col){
                    System.out.println("JA");
                    return;
                }

            }
        }
    }

    public static void robotTest(){
        Color a = new Color(62,134,160);
        for(int i = 1 ; i < 200; i+=4) {
            for (int j = 1; j< 200; j+=4){
                Color c = Util.getRobot().getPixelColor(i,j);
                if(c.equals(a)){
                    System.out.println("JA");
                    return;
                }
            }
        }
    }

    @Override
    public void onLoop() throws InterruptedException, IOException {
        String stateInfo = "";


        if(scanner.ready()){
            stateInfo = scanner.readLine();
        }

        if(stateInfo.contains("fallen")){

            int[] pos = getMousePos(stateInfo);
            Util.mouseClick(pos[0], pos[1], true);

            Thread.sleep((int)(Math.random()*200)+4000);

        } else if(stateInfo.contains("caught")) {
            int[] pos = getMousePos(stateInfo);
            Util.mouseClick(pos[0], pos[1], true);

            Thread.sleep((int)(Math.random()*200)+4000);
        } else if(stateInfo.contains("dis")){
            int[] pos = getMousePos(stateInfo);
            Util.mouseClick(pos[0], pos[1], true);

            Thread.sleep((int)(Math.random()*200)+4000);
        }
    }
}

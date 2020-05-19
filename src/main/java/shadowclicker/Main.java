package shadowclicker;

import com.github.joonasvali.naturalmouse.api.MouseMotionFactory;
import com.github.joonasvali.naturalmouse.util.FactoryTemplates;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

import java.awt.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args)  throws InterruptedException {
        boolean running = true;
        Util.testColor(110, 176);
        Scanner myObj = new Scanner(System.in);  // Create a Scanner objec

        while(true){
            String stateInfo = "";


            stateInfo = myObj.nextLine();

            System.out.println(stateInfo);

            if(stateInfo.contains("fallen")){

                System.out.println("werkt");
                int[] pos = getMousePos(stateInfo);
                Util.mouseClick(pos[0], pos[1]);

                Thread.sleep(4000);

            } else if(stateInfo.contains("caught")) {
                System.out.println("werkt");
                int[] pos = getMousePos(stateInfo);
                Util.mouseClick(pos[0], pos[1]);

                Thread.sleep(4000);
            } else if(stateInfo.contains("dis")){
                System.out.println("werkt");
                int[] pos = getMousePos(stateInfo);
                Util.mouseClick(pos[0], pos[1]);

                Thread.sleep(4000);
            }

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

}

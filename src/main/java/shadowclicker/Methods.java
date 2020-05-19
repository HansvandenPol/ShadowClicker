package shadowclicker;

import com.github.joonasvali.naturalmouse.api.MouseMotionFactory;
import com.github.joonasvali.naturalmouse.util.FactoryTemplates;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Methods {
    private  Robot robot;
    private  MouseMotionFactory mouse = FactoryTemplates.createAverageComputerUserMotionFactory();

    public Methods() {
        try{
            robot = new Robot();
        } catch (AWTException aw) {

        }
    }

    public int[] pixelSearch(int startX, int startY, int endX, int endY, int r, int g, int b, int speed) {
        Color theColor = new Color(r,g,b);
        int[] coords = new int[2];


        for(int j = startY; j < endY; j+=speed) {
            for(int i = startX; i < endX; i+=speed) {
                if(robot.getPixelColor(i , j).equals(theColor)){
                    coords[0] = i;
                    coords[1] = j;
                    return coords;
                }
            }
        }

        return coords;
    }

    public boolean isColorAt(int xPos, int yPos, int r, int g, int b) {
        Color theColor = robot.getPixelColor(xPos, yPos);
        Color compare = new Color(r, g, b);

        return theColor.equals(compare);
    }

    public void testColor(int xPos, int yPos){
        Color c = robot.getPixelColor(xPos, yPos);
        System.out.println("R"+c.getRed()+"G"+c.getGreen()+"B"+c.getBlue());
    }

    public void click(){
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);

        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void mouseClick(int xPos, int yPos) throws InterruptedException {
        mouse.move(xPos, yPos);
        robot.delay(200);
        click();
    }

    public void dropAll() throws InterruptedException {
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.delay(50);

//        mouse.move(1690, 473);
//        robot.delay(200);

        mouse.move(1781, 473);
        robot.delay(200);

        click();
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }

    public boolean isInvFull(){
        return !isColorAt(1822,484,69,60,51);
    }
}

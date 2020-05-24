package shadowclicker;

import com.github.joonasvali.naturalmouse.api.MouseMotionFactory;
import com.github.joonasvali.naturalmouse.util.FactoryTemplates;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Util {
    private static Robot robot;
    private static MouseMotionFactory mouse;

    static {
        try {
            robot = new Robot();
            mouse = FactoryTemplates.createFastGamerMotionFactory();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static boolean pixelSearch(int startX, int startY, int endX, int endY, int r, int g, int b, int speed) {
        Color theColor = new Color(r,g,b);
        for(int j = startY; j < endY; j+=speed) {
            for(int i = startX; i < endX; i+=speed) {
                if(robot.getPixelColor(i , j).equals(theColor)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isColorAt(int xPos, int yPos, int r, int g, int b) {
        Color theColor = robot.getPixelColor(xPos, yPos);
        Color compare = new Color(r, g, b);

        return theColor.equals(compare);
    }

    public static void testColor(int xPos, int yPos){
        Color c = robot.getPixelColor(xPos, yPos);
        System.out.println("R"+c.getRed()+"G"+c.getGreen()+"B"+c.getBlue());
    }

    public static void click(){
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

        robot.delay((int)(Math.random() * 50) + 50);

        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public static void mouseClick(int xPos, int yPos) throws InterruptedException {
        mouse.move(xPos, yPos);
        robot.delay((int)(Math.random() * 10) + 45);
        click();
    }

    public static void dropAll() throws InterruptedException {
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.delay(50);

//        mouse.move(1690, 473);
//        robot.delay(200);

        mouse.move(1781, 473);
        robot.delay(200);

        click();
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }

    public static Robot getRobot(){
        return robot;
    }
}

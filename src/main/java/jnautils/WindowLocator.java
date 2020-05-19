package jnautils;

import com.sun.jna.Native;
import com.sun.jna.platform.WindowUtils;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;
import shadowclicker.Util;

import java.awt.*;
import java.util.Arrays;

public class WindowLocator {
    public static Rectangle getRect(String windowName) {
        final Rectangle rect = new Rectangle(0, 0, 0, 0); //needs to be final or effectively final for lambda

        WindowUtils.getAllWindows(false).forEach(desktopWindow -> {
            if (desktopWindow.getTitle().contains(windowName)) {
                rect.setRect(desktopWindow.getLocAndSize());
                System.out.println(rect.y);
                System.out.println(rect.x);

            }
        });

        return rect;
    }

    public static void main(String[] args) {
        String windowName = "Naamloos - Kladblok";
        Rectangle rect;
        try {
            rect = WindowLocator.getRect(windowName);
            Util.mouseClick(rect.x, rect.y);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

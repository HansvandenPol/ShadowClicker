import accountswitcher.RobotTyper;
import jnautils.User32;
import jnautils.Win32WindowUtils;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class RobotTyperTest extends JFrame implements KeyListener {
    char[] charsPressed;
    int count = 0;
    public RobotTyperTest(){
        super("default");
        JPanel p = new JPanel();
        addKeyListener(this);

    }
    @Test
    public void typeAString() throws InterruptedException, AWTException {
        String test = "string";
        setVisible(true);
        charsPressed = new char[6];

        Robot r = new Robot();

        RobotTyper.type(test);

        String input = String.valueOf(charsPressed);
        assertEquals(input, test);
    }

    @Test
    public void shouldLoginWithGoodCredentials() throws AWTException, InterruptedException {
        Robot r = new Robot();
        String tile = "RuneLite";
        User32.INSTANCE.SetFocus(Win32WindowUtils.GetWindowHandle(tile.toUpperCase(), null));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        charsPressed[count] = e.getKeyChar();
        count++;

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

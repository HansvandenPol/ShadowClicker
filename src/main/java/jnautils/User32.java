package jnautils;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

public interface User32 extends StdCallLibrary {
    User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);
    WinDef.HWND GetParent(WinDef.HWND hWnd);
    WinDef.HWND FindWindow(String lpClassName, String lpWindowName);
    WinDef.HWND SetFocus(WinDef.HWND hWnd);
    WinDef.HWND FindWindowEx(WinDef.HWND hwndParent, WinDef.HWND hwndChildAfter, String lpszClass, String lpszWindow);
    int GetWindowText(WinDef.HWND hWnd, char[] lpString, int nMaxCount);
}

package jnautils;

import com.sun.jna.platform.win32.WinDef;

public class Win32WindowUtils {
    private static final int WIN_TITLE_MAX_SIZE = 512;

    public static WinDef.HWND GetWindowHandle(String strSearch, String strClass) {
        char[] lpString = new char[WIN_TITLE_MAX_SIZE];
        String strTitle;
        int iFind = -1;
        WinDef.HWND hWnd = User32.INSTANCE.FindWindow(strClass, null);
        while(hWnd != null) {
            User32.INSTANCE.GetWindowText(hWnd, lpString, WIN_TITLE_MAX_SIZE);
            strTitle = new String(lpString);
            strTitle = strTitle.toUpperCase();
            iFind = strTitle.indexOf(strSearch);
            if(iFind != -1) {
                return hWnd;
            }
            hWnd = User32.INSTANCE.FindWindowEx(null, hWnd, strClass, null);
        }
        return hWnd;
    }
}

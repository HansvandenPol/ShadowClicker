package shadowclicker;

import java.util.Scanner;

public class ScannerManager {
    private Scanner scanner;

    public ScannerManager(){

    }
    public void close(){
        this.scanner.close();
    }

    public  void open(){
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner(){
        return scanner;
    }
}

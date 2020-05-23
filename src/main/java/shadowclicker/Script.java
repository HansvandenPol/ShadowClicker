package shadowclicker;

import java.awt.*;
import java.io.IOException;

public abstract class Script {
    private Methods methods = new Methods();
    private ScannerManager sm;

    public Methods getMethods(){
        return methods;
    }
    public abstract void onLoop() throws InterruptedException, IOException;

    public void sleep(int milSec) throws InterruptedException {
        Thread.sleep(milSec);
    }

    public void setScannerManager(ScannerManager sm) {
        this.sm = sm;
    }

    public ScannerManager getSm() {
        return sm;
    }
}

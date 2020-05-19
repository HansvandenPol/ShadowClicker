package shadowclicker;

import java.awt.*;

public abstract class Script {
    private Methods methods = new Methods();

    public Methods getMethods(){
        return methods;
    }
    public abstract void onLoop() throws InterruptedException;

    public void sleep(int milSec) throws InterruptedException {
        Thread.sleep(milSec);
    }
}

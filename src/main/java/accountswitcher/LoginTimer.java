package accountswitcher;

import org.json.simple.JSONObject;

public class LoginTimer {
    private long startTime;
    private long endTime;

    public void startTimerFor(int durationInMinutes, int offsetInMinutes){
        double randomOffset = (Math.random() * offsetInMinutes) - (offsetInMinutes/2);
        System.out.println(randomOffset);
        startTime = System.nanoTime();
        System.out.println(startTime);
        endTime = (long) (startTime + ((durationInMinutes + randomOffset) * 60) * 1_000_000_000);
        System.out.println(endTime);
    }

    public boolean shouldLogOut() {
        return System.nanoTime() >= endTime;
    }
}

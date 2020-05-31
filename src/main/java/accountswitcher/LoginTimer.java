package accountswitcher;

import org.json.simple.JSONObject;

public class LoginTimer {
    private long startTime;
    private long endTime;
    private double offset;

    public void startTimerFor(int durationInMinutes, int offsetInMinutes){
        double minus = ((double)offsetInMinutes/2);
        double randomNumber = Math.random() * offsetInMinutes;

        offset = randomNumber - minus;
        startTime = System.nanoTime();
        endTime = (long) (startTime + ((durationInMinutes + offset) * 60) * 1_000_000_000);
    }

    public boolean shouldLogOut() {
        return System.nanoTime() >= endTime;
    }

    public long getStartTime(){
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public double getOffset() {
        return offset;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}

import accountswitcher.AccountLoader;
import accountswitcher.LoginManager;
import org.json.simple.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTimerTest {
    LoginManager lm = new LoginManager();
    AccountLoader al = new AccountLoader("C:\\Users\\hansv\\IdeaProjects\\ShadowClicker\\src\\test\\java\\OneCanidate.json");
    @Test
    public void shouldStartTimerWhenLoggedIn(){
        al.readJson();
        JSONObject first = al.getFirstCanidate();
        assertFalse(lm.getTimer().getStartTime() > 0);
        assertFalse(lm.getTimer().getEndTime() > 0);
        lm.login(first, 1, 0);
        assertTrue(lm.getTimer().getStartTime() > 0);
        assertTrue(lm.getTimer().getEndTime() > 0);
    }

    @Test
    public void shouldCreateCorrectEndTime(){
        al.readJson();
        JSONObject first = al.getFirstCanidate();
        lm.login(first, 2, 0);
        long start = lm.getTimer().getStartTime();
        long end = lm.getTimer().getEndTime();
        assertEquals(end, (start + 120_000_000_000L));

        lm = new LoginManager();
        lm.login(first, 2, 1);
        long start2 = lm.getTimer().getStartTime();
        long end2 = lm.getTimer().getEndTime();
        double offset = lm.getTimer().getOffset();
        long minus = (long)(offset * 60 * 1_000_000_000L);
        assertTrue(end2 - (start2 + 120_000_000_000L + minus) < 10 || end2 - (start2 + 120_000_000_000L + minus) > 10);
    }

    @Test
    public void shouldLogoutTest(){
        al.readJson();
        JSONObject first = al.getFirstCanidate();
        lm.login(first, 2, 0);
        assertFalse(lm.shouldLogout());
        lm.getTimer().setEndTime(lm.getTimer().getEndTime() - 180_000_000_000L);
        assertTrue(lm.shouldLogout());
    }
}

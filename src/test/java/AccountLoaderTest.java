import accountswitcher.AccountLoader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;


public class AccountLoaderTest {
    AccountLoader ac = new AccountLoader();

    @Test
    public void shouldReadJsonObjectFromPath(){
        assertNull(ac.getJsonFile());
        ac.readJson();
        assertNotNull(ac.getJsonFile());
    }

    @Test
    public void shouldRetrieveACanidateWhenAvaileble(){
        ac =  new AccountLoader("C:\\Users\\hansv\\IdeaProjects\\ShadowClicker\\src\\test\\java\\OneCanidate.json");
        ac.readJson();
        assertNotNull(ac.getFirstCanidate());
    }

    @Test
    public void shouldRetrieveNullWhenNoCanidate(){
        ac = new AccountLoader("C:\\Users\\hansv\\IdeaProjects\\ShadowClicker\\src\\test\\java\\BADcanidate.json");
        ac.readJson();
        assertNull(ac.getFirstCanidate());
    }

    @Test
    public void shouldSetPlayedForValue(){
        ac = new AccountLoader("C:\\Users\\hansv\\IdeaProjects\\ShadowClicker\\src\\test\\java\\OneCanidate.json");
        ac.readJson();
        JSONObject first = ac.getFirstCanidate();
        assertEquals(first.get("played"), false);
        ac.setPlayed(first, true);

        assertEquals(first.get("played"), true);
        ac.setPlayed(first, false);
    }

    @Test
    public void shouldUpdateJson(){
        ac = new AccountLoader("C:\\Users\\hansv\\IdeaProjects\\ShadowClicker\\src\\test\\java\\Updateable.json");
        ac.readJson();
        JSONObject first = ac.getFirstCanidate();
        ac.setPlayed(first, true);
        ac.readJson();
        JSONArray array = (JSONArray) ac.getJsonFile().get("accounts");
        JSONObject theFirst = (JSONObject) array.get(0);
        assertEquals(theFirst.get("played"), true);

        ac.setPlayed(theFirst, false);
    }

    @Test
    public void shouldReturnRightCredentials(){
        ac = new AccountLoader("C:\\Users\\hansv\\IdeaProjects\\ShadowClicker\\src\\test\\java\\OneCanidate.json");
        ac.readJson();
        JSONObject first = ac.getFirstCanidate();
        assertEquals(first.get("username"), "Hendrik");
        assertEquals(first.get("password"), "OINK");
        assertEquals(first.get("played"), false);
    }
}

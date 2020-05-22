import accountswitcher.AccountLoader;
import accountswitcher.LoginManager;
import org.json.simple.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LoginManagerTest {
    LoginManager lm = new LoginManager();

    @Test
    public void shouldFindNewAccount(){
        lm.setAccount(null);
        lm.setAccountManager(new AccountLoader("C:\\Users\\hansv\\IdeaProjects\\ShadowClicker\\src\\test\\java\\MoreCandidates.json"));
        JSONObject first = lm.getNextAccount();
        assertNotNull(first);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRunTimeWhenNotFound() {
        lm = new LoginManager();
        lm.setAccount(null);
        lm.setAccountManager(new AccountLoader("C:\\Users\\hansv\\IdeaProjects\\ShadowClicker\\src\\test\\java\\BADcanidate.json"));
        JSONObject first = lm.getNextAccount();
    }

    @Test
    public void shouldUpdateAccountStatusOnLogout(){

    }
}

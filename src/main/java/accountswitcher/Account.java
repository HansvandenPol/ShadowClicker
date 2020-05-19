package accountswitcher;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class Account {
    private final String DEFAULT_PATH = "C:\\Users\\hansv\\IdeaProjects\\ShadowClicker\\src\\main\\java\\accountswitcher\\accounts.JSON";
    private String pathToAccs = DEFAULT_PATH;
    private JSONParser jsonParser;
    private JSONObject jsonFile;
    private LoginTimer loginTimer;

    public Account() {
    }

    public Account(String pathToAccs) {
        this.pathToAccs = pathToAccs;
    }

    public void readJson() {
        jsonParser = new JSONParser();
        try {
            Object object = jsonParser.parse(new FileReader(pathToAccs));
            JSONObject jsonObject = (JSONObject) object;

            this.jsonFile = jsonObject;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateJson(JSONObject jsonObject) {
        try {
            FileWriter file = new FileWriter(pathToAccs);
            file.write(jsonObject.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPlayed(JSONObject object, boolean state) {
        object.put("played", state);
        updateJson(jsonFile);
    }

    public JSONObject getFirstCanidate() {
        JSONArray accounts = (JSONArray) jsonFile.get("accounts");
        if (accounts != null) {
            Iterator<JSONObject> iterator = accounts.iterator();
            while (iterator.hasNext()) {
                JSONObject account = iterator.next();
                if (!(Boolean) account.get("played")) {
                    return account;
                }
            }
        }
        return null;
    }
}

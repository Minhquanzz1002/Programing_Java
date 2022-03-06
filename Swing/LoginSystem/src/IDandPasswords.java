import java.util.HashMap;

public class IDandPasswords {
    HashMap<String, String> loginInfo = new HashMap<String, String>();
    IDandPasswords(){
        loginInfo.put("admin", "123456");
        loginInfo.put("minhquan","minhquan1001");

    }

    protected HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }
}

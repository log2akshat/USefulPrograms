import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {

    private Internet internet = new RealInternet();
        private static List<String> bannedSites;
        static {
            bannedSites = new ArrayList<>();
            bannedSites.add("abc.com");
            bannedSites.add("def.com");
            bannedSites.add("ghi.com");
            bannedSites.add("jkl.com");
            bannedSites.add("xyz.com");
        }

    @Override
    public void connectTo(String siteName) throws Exception {
        if (bannedSites.contains(siteName.toLowerCase())) {
            throw new Exception("Access Denied");
        }
        internet.connectTo(siteName);
    }
    
}

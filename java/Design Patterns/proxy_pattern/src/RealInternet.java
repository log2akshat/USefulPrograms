public class RealInternet implements Internet {

    @Override
    public void connectTo(String siteName) throws Exception {
        System.out.printf("Connecting to %s\n", siteName);
    }
    
}

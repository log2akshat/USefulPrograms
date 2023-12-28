public class Client {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        try {
            internet.connectTo("pfug.org");
            internet.connectTo("akshatsingh.co.in");
            internet.connectTo("abc.com");
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
    }
}

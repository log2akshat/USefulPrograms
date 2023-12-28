public class Client {
    
    public static void main(String args[]) {
        LogProcessor logObject = new DebugLogProcessor(new InfoLogProcessor(new ErrorLogProcessor(null)));
    
        logObject.log(LogProcessor.ERROR, "exception happened");
        logObject.log(LogProcessor.INFO, "info message");
        logObject.log(LogProcessor.DEBUG, "debug message");
    }
}

public abstract class LogProcessor {
    
    public static int DEBUG = 1;
    public static int INFO = 2;
    public static int ERROR = 3;
    
    LogProcessor nextLoggerProcessor;
    
    LogProcessor(LogProcessor loggerProcessor) {
        this.nextLoggerProcessor = loggerProcessor;
    }
    
    public void log(int logLevel, String message) {
        if (nextLoggerProcessor != null) {
            nextLoggerProcessor.log(logLevel, message);
        }
    }
}

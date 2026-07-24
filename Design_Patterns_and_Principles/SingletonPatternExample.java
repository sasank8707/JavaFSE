public class SingletonPatternExample {

    public static void main(String[] args) {

        Logger firstLogger = Logger.getInstance();
        Logger secondLogger = Logger.getInstance();

        firstLogger.log("App started");

        System.out.println(firstLogger == secondLogger);
    }
}

class Logger {

    private static Logger logger;

    private Logger() {
        System.out.println("Log created");
    }

    public static Logger getInstance() {

        if (logger == null) {
            logger = new Logger();
        }

        return logger;
    }

    public void log(String msg) {
        System.out.println(msg);
    }
}
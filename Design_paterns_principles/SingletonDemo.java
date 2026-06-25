public class SingletonDemo {
    public static void main(String[] args) {
        SystemConfig primaryConfig = SystemConfig.fetchInstance();
        SystemConfig secondaryConfig = SystemConfig.fetchInstance();
        
        primaryConfig.displayMessage("Application Initialized");
        System.out.println(primaryConfig == secondaryConfig);
    }
}

class SystemConfig {
    private static SystemConfig instance;

    private SystemConfig() {
        System.out.println("Configuration Instance Created");
    }

    public static SystemConfig fetchInstance() {
        if (instance == null) {
            instance = new SystemConfig();
        }
        return instance;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}

package Others;

public class MainRunner extends Main {
    
    public static void main(String[] args) {

            Main main = new MainRunner();

            main.initializeClients();
            
            main.choseUserType();
            
            System.exit(0);
    }
}
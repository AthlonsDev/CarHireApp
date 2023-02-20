import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class LoginCustomer {
    

    public boolean EnterCredentials() {
        String username = "";
        String password = "";
        Scanner scanner = new Scanner(System.in);

        // enter username and pass it over
        System.out.println("Enter Username: ");
        username = scanner.nextLine();
        System.out.println("Enter Password: ");
        password = scanner.nextLine();
        
        // validate user
        if(validateUser(username, password)) {
            System.out.println("Login Successful");
            // set isLoggedIn to true
            Main.isLoggedIn = true;
            return true;
        }
        else {
            System.out.println("Login Failed");
            return false;
        }
        
    }


    public boolean validateUser(String u, String p) {

        // read the file and print it out
        HashMap<String, String> map = new HashMap<String, String>();
        File file = new File("C:\\Users\\athlo\\Desktop\\Uni\\SoftDev\\AdvSoft - Assignment\\Part-1\\Customers.json");
        try {
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                // put the content into a hashmap
                String[] split = data.split(",");
                for(String s : split) {
                    String[] split2 = s.split("=");
                    map.put(split2[0], split2[1]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        // check if the username and password match
        if(map.get("Username").equals(u) && map.get("Password").equals(p)) {
            return true;
        }
        else {
            return false;
        }
    }
}

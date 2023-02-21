package FileHandler;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

public class FileUploader {
    
    public void SaveCustomer(String username, String password) {
        // save the username and password to a JSON file

        HashMap<String, String> customer = new HashMap<String, String>();

        customer.put("Username", username);
        customer.put("Password", password);

        // check if username and passwords are not present in the file
        ValidateUser validateUser = new ValidateUser();
        String profileName = username + ".json";
        
        if(!validateUser.validateUser(username, null)) { // if username is not present in the file then add it as a new user
            try {
                File file = new File("C:\\Users\\athlo\\Desktop\\Uni\\SoftDev\\AdvSoft - Assignment\\Part-1\\Files\\Customers.json");
                File file2 = new File("C:\\Users\\athlo\\Desktop\\Uni\\SoftDev\\AdvSoft - Assignment\\Part-1\\Files\\" + profileName);
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(customer.toString());
                System.out.println("Saved");
                fileWriter.close();
            } catch (Exception e) { 
                System.out.println("Error: " + e.getMessage());
            }
        
        }    


    }

}

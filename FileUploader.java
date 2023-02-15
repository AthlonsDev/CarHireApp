import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class FileUploader {
    
    public void SaveCustomer(String username, String password) {
        // save the username and password to a JSON file

        HashMap<String, String> customer = new HashMap<String, String>();

        customer.put("Username", username);
        customer.put("Password", password);


        try {
            File file = new File("C:\\Users\\athlo\\Desktop\\Uni\\SoftDev\\AdvSoft - Assignment\\Part-1\\Customers.json");
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(customer.toString());
            System.out.println("Saved");
            fileWriter.close();
        } catch (Exception e) { 
            System.out.println("Error");
        }

        // read the file and print it out
        // File file = new File("C:\\Users\\athlo\\Desktop\\Uni\\SoftDev\\AdvSoft - Assignment\\Part-1\\Customers.json");
        // try {
        //     Scanner fileReader = new Scanner(file);
        //     while(fileReader.hasNextLine()) {
        //         String data = fileReader.nextLine();
        //         System.out.println(data);
        //     }
        // } catch (FileNotFoundException e) {
        //     e.printStackTrace();
        // }


    }

}

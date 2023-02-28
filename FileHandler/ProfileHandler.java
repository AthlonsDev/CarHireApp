package FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import Models.User;

public class ProfileHandler extends User {
    public ProfileHandler(String username, String password, String viewedCars, String savedCars, String hiredCars) {
        super(username, password, viewedCars, savedCars, hiredCars);
        //TODO Auto-generated constructor stub
    }

    private File currentDir = new File("");
    private String currentPath = currentDir.getAbsolutePath();

    public void readProfile(String user) {


        HashMap<String, String> userMap = new HashMap<String, String>();

        // read the file and store the username and password in a hashmap
        try {
            File file = new File(currentPath + "\\Files\\" + user + ".txt");
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                String[] dataSplit = data.split(",");
                for(int i = 0; i < dataSplit.length; i++) {
                    System.out.println(dataSplit[i]);
                    String[] dataSplit2 = dataSplit[i].split("=");
                    userMap.put(dataSplit2[0], dataSplit2[1]);
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(userMap.containsKey("savedCars"))
            setSavedCars(userMap.get("savedCars"));
            

    }
    
}

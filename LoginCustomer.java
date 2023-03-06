import FileHandler.ValidateUser;

public class LoginCustomer extends ValidateUser{
    

    public String loginCustomer(String username, String password) {      
        // validate user
        if(validateUser(username, password)) {
            System.out.println("Login Successful");
            return username;
        }
        else {
            System.out.println("Login Failed");
            return null;
        }
        
    }
}

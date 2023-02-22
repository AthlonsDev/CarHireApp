abstract class Customer {
    
 // create a model object for the user
 private String username;
 private String password;
 private String viewedCars;
 private String savedCars;
 private String hiredCars;

 public Customer(String username, String password, String viewedCars, String savedCars, String hiredCars) {
     this.username = username;
     this.password = password;
     this.viewedCars = viewedCars;
     this.savedCars = savedCars;
     this.hiredCars = hiredCars;
 }

 public String getUsername() {
     return username;
 }

 public void setUsername(String username) {
     this.username = username;
 }

 public String getPassword() {
     return password;
 }

 public void setPassword(String password) {
     this.password = password;
 }

 public String getViewedCars() {
     return viewedCars;
 }

 public void setViewedCars(String viewedCars) {
     this.viewedCars = viewedCars;
 }

 public String getSavedCars() {
     return savedCars;
 }

 public void setSavedCars(String savedCars) {
     this.savedCars = savedCars;
 }

 public String getHiredCars() {
     return hiredCars;
 }

 public void setHiredCars(String hiredCars) {
     this.hiredCars = hiredCars;
 }

}

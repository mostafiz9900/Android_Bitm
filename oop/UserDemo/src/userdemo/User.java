
package userdemo;


public class User {
    private String userName;
    private String password;
    private String fullName;
    private int age;

    public User() {
    }

    public User(String userName, String password, String fullName, int age) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }
    
    
}

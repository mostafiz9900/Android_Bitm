
package userdemo;

import java.util.ArrayList;
import java.util.List;

public class TestUser {

    
    public static void main(String[] args) {
        List<User> userList=new ArrayList<>();
        User user=new User("mostafiz9900", "mostafiz9900", "Md Mostafizur Rahman", 26);
        userList.add(user);
        
         User user2=new User("mahabub", "mahabub99", "Md Mahabuab Rahman", 29);
        userList.add(user2);
        
        userList.add(new User("sofiqul54", "sofiq45", "Sofiqul Islam", 30));
        
        for (User s:userList) {
            System.out.println(s.getFullName());
        }
    }
    
}

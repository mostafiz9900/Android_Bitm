
package oopproject_2;

public class OopProject_2 {

    
    public static void main(String[] args) {
      
        Student  student =new Student(246642, "Mostafizur", "mostafiz9900@gmail.com", 27);
        System.out.println(student.getName());
        
        student.setAddress("Mirpur-2");
        
        System.out.println(student.getAddress());
        System.out.println(student.getAge());
    }
    
}

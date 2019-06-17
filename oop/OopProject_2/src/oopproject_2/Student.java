

package oopproject_2;



public class Student {
    private int id;
    private String name;
    private String email;
    private int age;
    private String address;

    public Student() {
    }
    

    public Student(int id, String name, String email, int age) {
        this();
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

  

    public Student(int id, String name, String email, int age, String address) {
        this(id, name, email, age);
                
        this.address = address;
    }
    

    public void setAddress(String address) {
        this.address = address;
    }
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
    
}

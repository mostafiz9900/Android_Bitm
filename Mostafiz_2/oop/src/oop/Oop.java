package oop;

public class Oop {

    public static void main(String[] args) {
        Student student = new Student();
        student.fName = "Mostafiz";
        student.age = 26;
        student.email = "mostafiz9900@gmail.com";
        //String fullName=student.getStudent();
        System.out.println(student.getStudent());

        Student student2 = new Student();
        student2.fName = "Mahabub";
        student2.age = 30;
        student2.email = "mahabub@gmail.com";
        System.out.println(student2.getStudent());
        
        Student student3=student;
        student3.age=20;
        
        System.out.println(student3.getStudent());
        student3=student2;
        System.out.println(student3.getStudent());
        student=null;
        student3=student;
        System.out.println(student3.getStudent());

    }

}

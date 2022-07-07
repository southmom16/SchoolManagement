/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLTH.java;

public class Student extends Person{
     
    private String className;

    public Student() {
    }

    public Student(String id, String name, String address, String email, String phone_number, String nationality, String className) {
        super(id, name, address, email, phone_number, nationality);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}

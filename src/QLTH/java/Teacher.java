/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLTH.java;

/**
 *
 * @author southmom16
 */
public class Teacher extends Person{
    private String specialization;

    public Teacher() {
    }

    public Teacher(String id, String name, String address, String email, String phone_number, String nationality, String specialization) {
        super(id, name, address, email, phone_number, nationality);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
}

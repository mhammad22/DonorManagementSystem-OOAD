/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_fall_2019;

/**
 *
 * @author Dell
 */
public class Person 
{
    String Name_P;
    int Cnic_P;

    public Person(String Name_P, int Cnic_P) {
        this.Name_P = Name_P;
        this.Cnic_P = Cnic_P;
    }
    
    void PrintPersonDetails()
    {
        System.out.println("Name = "+Name_P);
        System.out.println("Cnic = "+Cnic_P);
    }
    
}


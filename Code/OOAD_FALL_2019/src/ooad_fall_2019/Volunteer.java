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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Volunteer 
{
    List<Project> VProject;
    int V_ID;
    String Rank;
    String Availability;
    String Name_V;
    String Cnic_V;
    
    
    public Volunteer(int V_ID, String Rank, String Availability, String Name_P, String Cnic_P) 
    {
        this.Name_V=Name_P;
        this.Cnic_V=Cnic_P;
        this.VProject =new ArrayList<>();
        this.V_ID = V_ID;
        this.Rank = Rank;
        this.Availability = Availability;
    }

    public Volunteer() {
    }
    
    


    
}


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
public class Donor extends Person
{
    List<Fund> Donations;
    List<Project> p;
    Organization org;
  
    String ID_Donor;

    public Donor() {
        super(null, 0);
    }
    
    

    public Donor( String ID_Donor, String Name_P, int Cnic_P) 
    {
        super(Name_P, Cnic_P);
        this.Donations = new ArrayList<>();
        this.ID_Donor = ID_Donor;
        this.p=new ArrayList<>();
    }
    
    void addFundInDonor(Fund f)
    {
        Donations.add(f);
    }
    
     void PrintFundsOfAllDonor()
     {
         for(int i=0;i<this.Donations.size();i++)
         {
            this.Donations.get(i).PrintFundinfo();
         }
     }
    
}


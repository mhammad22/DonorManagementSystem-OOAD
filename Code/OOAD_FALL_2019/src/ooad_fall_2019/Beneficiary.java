/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_fall_2019;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Beneficiary 
{
    String Title;
    String Address;
    String B_ID;
    int income;
    Date dob;
    String PhoneNo;
    List<Assessor> A;
    boolean flag;
    int total_amount;
    List<Project> p;
    List<Donor> d;
    String Name_P;
    String Cnic_P;

    public Beneficiary() {
    }
   
    
    
    public Beneficiary(String Title, String Address, int income,  String PhoneNo)
    {
        
        this.Title = Title;
        this.Address = Address;
        this.income = income;
        this.PhoneNo = PhoneNo;
        this.d=new ArrayList<>();
        this.A=new ArrayList<>();
        this.p=new ArrayList<>();
        this.total_amount=0;
    }
    
    void ShowProject()
    {
        for(int i=0;i<p.size();i++)
        {
            p.get(i).PrintProjectInfo();
        }
    }
    
    
    void ShowDonor()
    {
        for(int i=0;i<d.size();i++)
        {
            d.get(i).PrintPersonDetails();
        }
    }
    
    
}


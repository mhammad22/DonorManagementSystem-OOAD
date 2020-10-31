/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_fall_2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Assessor extends Person
{
    int A_ID;   
     List<String> Questions;
     List<Beneficiary> SelectedBeneficiary;
     Beneficiary b;

    public Assessor(int A_ID,String Name_P, int Cnic_P) 
    {
        super(Name_P, Cnic_P);
        this.A_ID = A_ID;
        this.Questions = new ArrayList<>();
        this.SelectedBeneficiary=new ArrayList<>();
     
    }
    
    Boolean VerifyBeneficiary(Beneficiary b)
    {
        boolean flag=false;
        String temp;
        int count=0;
        
        for(int i=0;i<Questions.size();i++)
        {
            System.out.print((i+1)+".");
            System.out.println(Questions.get(i));
            
            Scanner in=new Scanner(System.in);
            temp=new String(in.nextLine());
            
           if(temp.contains("y"))
           {
               count++;
           }
  
        }
        
        if(count>1)
        {
            flag=true;
        }
        else
        {
            flag=false;
        }
        
      return flag;
    }
    
    
    void AddVerifiedBeneficairy(Beneficiary b)
    {
        SelectedBeneficiary.add(b);
    }
    
    
    Boolean CheckBeneficirayInList(Beneficiary b)
    {
        boolean flag=false;
        for(int i=0;i<SelectedBeneficiary.size();i++)
        {
            if(SelectedBeneficiary.get(i).Name_P.equals(b.Name_P))
            {
                flag=true;
            }
        }
        return flag;
    }
    
    
}

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
public class FundCollection 
{
    Volunteer V;
    Organization O;
    Fund F;
    List<Donor> Collection;

    public FundCollection() 
    {
        this.Collection=new ArrayList<>();
    }
    
    void AddDonorInFundCollection(Donor d)
    {
        Collection.add(d);
    }
    
    
    void SearchDonorFundCollection(Donor d)
    {
        for(int i=0;i<Collection.size();i++)
        {
            Donor dn=Collection.get(i);
            if(dn.Name_P.equals(d.Name_P))
            {
                dn.PrintPersonDetails();
                dn.PrintFundsOfAllDonor();
            }
            
        }
    }
    
    
    
}


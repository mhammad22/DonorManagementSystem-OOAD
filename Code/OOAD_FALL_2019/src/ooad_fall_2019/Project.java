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
public class Project 
{
     Organization Org;
    int ProjectBudget;
    String ProjectManager;
    Team t_Volunteers;
    List<Donor> ProjectDonor;
    List<Beneficiary> bn;
    String ProjectID;
    String Goals;

    public Project() {
    }
    
    
    
    public Project(String goals,int PB,String P_ID,String PM) 
    {
        ProjectDonor=new ArrayList<>();
        bn=new ArrayList<>();
        this.Goals=goals;
        this.ProjectBudget=PB;
        this.ProjectManager=PM;
        this.ProjectID=P_ID;
        this.t_Volunteers=new Team();
    }
    
    
    void PrintProjectInfo()
    {
        System.out.println("Project Name = "+Goals);
        System.out.println("Project Manager = "+ProjectManager);
        System.out.println("Project ID = "+ProjectID);
    }
    
    
    void SearchDonorProject(Donor dr)
    {
        for(int i=0;i<ProjectDonor.size();i++)
        {
            if(ProjectDonor.get(i).Name_P==dr.Name_P)
            {
                ProjectDonor.get(i).PrintPersonDetails();
            }
        }
    }
    
    
   
    
    
    void ShowDonorOfGivenProject(Project p)
    {
        for(int i=0;i<p.ProjectDonor.size();i++)
        {
            p.ProjectDonor.get(i).PrintPersonDetails();
        }
    }
    
    
}


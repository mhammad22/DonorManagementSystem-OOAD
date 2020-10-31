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
public class Organization 
{
    List<Volunteer> Volunteers;
    List<Project> Projects;
    List<Donor> Donors;
    List<Beneficiary> beneficiary;
    String Name;
    String Moto;

    public Organization() 
    {
        this.Volunteers=new ArrayList<>();
        this.Donors=new ArrayList<>();
        this.Projects=new ArrayList<>();
        this.beneficiary=new ArrayList<>();
        this.Name=" ";
        this.Moto=" ";
        
    }
    
    public void AddProject(Project p)
    {
        Projects.add(p);
    }
    
    public void AddVolunteer(Volunteer V)
    {
        Volunteers.add(V);
    }
    
    //use case numebr 4
    void RemoveTeamMember(String name)
    {
        for(int i=0;i<Projects.size();i++)
        {
            for(int j=0;j<Projects.get(i).t_Volunteers.V_Team.size();j++)
            {
                if(Projects.get(i).t_Volunteers.V_Team.get(j).Name_P.equals(name))
                {
                    Projects.get(i).t_Volunteers.V_Team.remove(j);
                }
            }
        }
    }
    
     void addTeamMember(Person p1)
    {
        for(int i=0;i<Projects.size();i++)
        {
            Projects.get(i).t_Volunteers.V_Team.add(p1);
        }
    }
    
    
    void PrintProjectDetails()
    {
        for(int i=0;i<Projects.size();i++)
        {
            System.out.println("Project Goals = "+Projects.get(i).Goals);
            System.out.println("Project Manager =  "+Projects.get(i).ProjectManager);
            System.out.println("Project ID = "+Projects.get(i).ProjectID);
            System.out.println("Project Budget = "+Projects.get(i).ProjectBudget);
            
            for(int j=0;j<Projects.get(i).t_Volunteers.V_Team.size();j++)
            
            System.out.println("Volunteers = "+Projects.get(i).t_Volunteers.V_Team.get(j).Name_P);
            
        }
    }
    
    void SearchProjectByName(String name)
    {
        for(int i=0;i<Projects.size();i++)
        {
            if(name == Projects.get(i).Goals)
            {
                Projects.get(i).PrintProjectInfo();
            }
        }
    }
    
    void SearchProjectByManager(String name)
    {
        for(int i=0;i<Projects.size();i++)
        {
            if(name == Projects.get(i).ProjectManager)
            {
                Projects.get(i).PrintProjectInfo();
            }
        }
    }
    
      
    
}

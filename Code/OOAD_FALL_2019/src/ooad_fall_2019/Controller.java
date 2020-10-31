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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Controller 
{
   MY_DB mydb=new MY_DB();
   
    public Controller() 
    {
        
    }
    
    public boolean isNumeric(String strNum) 
    {
        boolean flag=mydb.isNumeric(strNum);
        return flag;
    }
    
    void addProjectinDB(int tid,int pid,String name,String cnic,String Manager,int Budget)
    {
      // MY_DB obj=new MY_DB();
       mydb.addProjectinDB(tid, pid, name, cnic, Manager, Budget);
    }
    
     List<String> ReturnTeamIDList(List<String> V)
    {
        return mydb.ReturnTeamIDList(V);
    }
    
    public List<Volunteer> ShowTeamMemebersOfProject(int Project_ID, List<Volunteer> vol)
    {
      // MY_DB mydb=new MY_DB();
       List<Volunteer> obj;
       obj=mydb.ShowTeamMemebersOfProject(Project_ID,vol);    
       return obj;
    }
    
    void addMembers(int vid,String name,String cnic,String rank,int tid,String ava)
    {
       //MY_DB obj=new MY_DB();
        mydb.addMembers(vid, name, cnic, rank, tid, ava);
    }
    
      void removeMembers(int vid,int tid)
    {
        //MY_DB mydb=new MY_DB();
        mydb.removeMembers(vid, tid);
    }
      
       public List<String> ShowProjectID(List<String> V)
    {
       // MY_DB mydb=new MY_DB();
        List<String> obj;
        obj=mydb.ShowProjectID(V);
        return obj;
    }
       
     
    void addDonor(int did,String name,int pid,String cnic,int cash,String item,String gift)
    {
        //MY_DB mydb=new MY_DB();
        mydb.addDonor(did, name, pid, cnic, cash, item, gift);
        
    }
    
    
    
     void addBeneficiary(int bid,int pid,String name,String cnic,String add,String pno,String dob,int income,int rm)
    {
        //MY_DB mydb=new MY_DB();
        mydb.addBeneficiary(bid, pid, name, cnic, add, pno, dob, income,rm);
    }
     
       public List<String> ShowBeneficiaryID(List<String> V)
    {
       // MY_DB mydb=new MY_DB();
        List<String> obj;
        obj=mydb.ShowBeneficiaryID(V);
        return obj;
    }
    
        public int ShowAssessorIDQuestions(int id)
    {
         // MY_DB mydb=new MY_DB();
          return mydb.ShowAssessorIDQuestions(id);
    }
    
        public List<String> ShowQuestionOfAssessor(int id,List<String> V)
     {
        //MY_DB mydb=new MY_DB();
        List<String> obj=null;
        obj=mydb.ShowQuestionOfAssessor(id, V);
        return obj;
     }
        
        
          void InsertInSelected(int id)
     {
        // MY_DB mydb=new MY_DB();
         mydb.InsertInSelected(id);
     }
          
          
      public List<String> ShowProjectDetails(String Name,List<String> V)
     {
         List<String> obj=null;
        // MY_DB mydb=new MY_DB();
         obj=mydb.ShowProjectDetails(Name, V);
         return obj;
     }
      
      public List<String> ShowProjectDetailsManager(String Name,List<String> V)
     {
         List<String> obj=null;
        // MY_DB mydb=new MY_DB();
         obj=mydb.ShowProjectDetailsManager(Name, V);
         return obj;
     }
    
      
       public  Boolean  IssueDonation(int Bid)
       {
           boolean flag=true;
        //   MY_DB mydb=new MY_DB();
           flag= mydb.IssueDonation(Bid);
           return flag;
       }
       public List<String> ReturnBeneficiaryID(List<String> V)
    {
      //  MY_DB mydb=new MY_DB();
        List<String> E;
        E=mydb.ReturnBeneficiaryID(V);
        return E;
    }
       
       
        public List<String> ReturnDonorList(List<String> V)
    {
        
        V=mydb.ReturnDonorList(V);
        return V;       
    }
        
         public List<String> ReturnDonorInfo(int did,List<String> V)
         {
             V=mydb.ReturnDonorInfo(did, V);
             return V;
         }
         
         public List<String> ReturnDonationOfDonor(int did,List<String> V)
     {
          V=mydb.ReturnDonationOfDonor(did, V);
          return V;
     }
     
    
     public List<String> ReturnProjectinfo(int did,List<String> V)
     {
         V=mydb.ReturnProjectinfo(did, V);
         return V;
     }
     
          public List<String> ReturnBeneficiaryOfProject(int bid,List<String> v)
     {
        v=mydb.ReturnBeneficiaryOfProject(bid, v);
        return v;
     }
          
          public List<String> ReturnDonorOfGivenProject(int pid,List<String> V)
     {
         V=mydb.ReturnDonorOfGivenProject(pid, V);
         return V;
     }
     
     public List<String> ReturnBeneficiaryList(List<String> V)
     {
         V=mydb.ReturnBeneficiaryList(V);
         return V;
     }
     
      public List<String> ReturnBeneficiaryProjectList(int bid,List<String> V)
      {
          return mydb.ReturnBeneficiaryProjectList(bid, V);
      }
      
        
       public List<String> ReturnDonorOfBeneficiary(int bid,List<String> V)
       {
           return mydb.ReturnDonorOfBeneficiary(bid, V);
       }
       
        List<String> ReturnProjectOfBeneficiary(int bid,List<String> V)
     {
         return mydb.ReturnProjectOfBeneficiary(bid, V);
     }

     
    
}


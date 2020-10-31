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
import com.mysql.jdbc.CallableStatement;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

import java.sql.ResultSet;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class MY_DB 
{
    Connection con;
    Statement stmt;

    public MY_DB() 
    {
        try {
            String s = "jdbc:sqlserver://localhost:52047;database=hammad";
            con = DriverManager.getConnection(s, "hammad", "12345678");

            stmt = con.createStatement();

        } catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public  boolean isNumeric(String strNum) 
    {
    if (strNum == null) 
    {
        return false;
    }
    try 
    {
        double d = Double.parseDouble(strNum);
    } 
    catch (NumberFormatException nfe) 
    {
        return false;
    }
    return true;
}
    
    
    //to check that query work or not
    void DisplayProject()
    {
        try 
        {
            ResultSet rs=stmt.executeQuery("select * from Project");
        while(rs.next())
        {
            System.out.println(rs.getString(3));
        }
            
        } catch (Exception e) 
        {
            System.out.println(e);
        }
        
    }
    
    
    List<String> ReturnTeamIDList(List<String> V)
    {
        V=new ArrayList<>();
        try 
        {
             String s="select * from Team ";
             ResultSet rs=stmt.executeQuery(s);
             while(rs.next())
             {
                 V.add(Integer.toString(rs.getInt(1)));
             }
             
        } 
        catch (Exception e) 
        {
            System.err.println(e);  
        }
        return V;
    }
    
    
    //use case numebr 1
    void addProjectinDB(int tid,int pid,String name,String cnic,String Manager,int Budget)
    {
        try 
        {
             System.out.println(name);
              String s=("insert into Project values("+tid+","+pid+",\'"+name+"\',\'"+cnic+"\',\'"+Manager+"\',"+Budget+")");
              int rs=stmt.executeUpdate(s);
            
        } catch (Exception e) 
        {
            System.out.println(e);
        }
    }
    
    //use case number 2
    public List<Volunteer> ShowTeamMemebersOfProject(int Project_ID, List<Volunteer> vol)
    {
        int store=0;
        try 
        {
            ResultSet rs=stmt.executeQuery("select * from Project where P_ID = " +Project_ID);
            while(rs.next())
            {
                Team obj=new Team();
                obj.vid=rs.getInt(1);
                store=obj.vid;
                
            }            
        } catch (Exception e) 
        {
            System.err.println(e);
        }
        
        try 
        {
          ResultSet rs1=stmt.executeQuery("select * from Volunteer where Team_ID = "+store);
           vol =new ArrayList<>();
          while(rs1.next())
          {
              Volunteer v1=new Volunteer();
              v1.Name_V=rs1.getString(2);
              v1.Cnic_V=rs1.getString(3);
              v1.Rank=rs1.getString(4);
              v1.Availability=rs1.getString(6);
              v1.V_ID=rs1.getInt(1); 
              vol.add(v1);
          }   
        } 
        catch (Exception e) 
        {
            System.err.println(e);
        }
        
        return vol;
    }
    
    
    //use case number 3
    void addMembers(int vid,String name,String cnic,String rank,int tid,String ava)
    {
        try 
        {
            String s=("insert into Volunteer values ("+vid+",\'"+name+"\',\'"+cnic+"\',\'"+rank+"\',"+tid+",\'"+ava+"\')");
            int rs=stmt.executeUpdate(s);
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
    
    void removeMembers(int vid,int tid)
    {
        try 
        {
          String s="DELETE from Volunteer where V_ID = "+vid+" AND Team_ID = "+tid;
         int rs=stmt.executeUpdate(s);   
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
      
    }
    
    
    
    //use case number 4
    public List<String> ShowProjectID(List<String> V)
    {
        try
        {
             String s="select * from Project";
             ResultSet rs=stmt.executeQuery(s);
             V = new ArrayList<>();
             while(rs.next())
             {
                 Project obj=new Project();
                 obj.ProjectID=rs.getString(2);
                 V.add(obj.ProjectID);
             }
        } 
        catch (Exception e)
        {
            System.err.println(e);
        }
    
        return V;  
    }
    
    
    
    void addDonor(int did,String name,int pid,String cnic,int cash,String item,String gift)
    {
        try 
        {
            String s=("insert into Donor values ("+pid+","+did+",\'"+name+"\',\'"+cnic+"\')") ;
            int rs=stmt.executeUpdate(s);
        } 
        catch (Exception e) 
        {
            System.err.println(e);
        }
        
        try 
        {
            String d=("insert into Fund values ("+did+","+cash+",\'"+gift+"\',\'"+item+"\')") ;
            int rs=stmt.executeUpdate(d);
        } 
        catch (Exception e) 
        {
            System.err.println(e);
        }
        
        
    }
    
    
    //use case number 5 
    
    void addBeneficiary(int bid,int pid,String name,String cnic,String add,String pno,String dob,int income,int rm)
    {
        try 
        {
            String s=("insert into Beneficiary values ("+bid+","+pid+",\'"+name+"\',\'"+cnic+"\',\'"+add+"\',\'"+pno+"\',\'"+dob+"\',"+income+","+rm+")");
            int rs=stmt.executeUpdate(s);
        } 
        catch (Exception e) 
        {
            System.err.println(e);
        }
    }
    
    
    //use case number 6
    public List<String> ShowBeneficiaryID(List<String> V)
    {
        try
        {
             String s="select * from Beneficiary";
             ResultSet rs=stmt.executeQuery(s);
             V = new ArrayList<>();
             while(rs.next())
             {
                 Beneficiary obj=new Beneficiary();
                 obj.B_ID=rs.getString(1);
                 V.add(obj.B_ID);
             }
        } 
        catch (Exception e)
        {
            System.err.println(e);
        }
    
        return V;  
    }
    
     public int ShowAssessorIDQuestions(int id)
    {
           int count1=0;
        try
        {
          
            ResultSet rs=stmt.executeQuery("select * from Questions where A_id = "+id);
             while(rs.next())
             {
                 
                count1++;
             }
        } 
        catch (Exception e)
        {
            System.err.println(e);
        }
         
    
        return count1;  
    }
     
     
     
     public List<String> ShowQuestionOfAssessor(int id,List<String> V)
     {
          try
        {
            if(id>2)
            {
                id=2;
            }
             String s="select * from Questions where A_id ="+id;
             ResultSet rs=stmt.executeQuery(s);
             V = new ArrayList<>();
             while(rs.next())
             {
                 Questions obj=new Questions();
                 obj.ques=rs.getString(2);
                 V.add(obj.ques);
             }
        } 
        catch (Exception e)
        {
            System.err.println(e);
        }
    
        return V;  
     }
    
     
     void InsertInSelected(int id)
     {
         try 
         {
             String s=("insert into selected values ("+id+")");
             int rs=stmt.executeUpdate(s);
             
             
                 
             
         }
         
         catch (Exception e) 
         {
             System.out.println(e);
         }
     }
     
     
     public List<String> ShowProjectDetails(String Name,List<String> V)
     {
         try 
         {
             String s=("select * from Project where Name_P = \'"+Name+"\'");
             ResultSet rs=stmt.executeQuery(s);
             V=new ArrayList<>();
             
             while(rs.next())
             {
                 V.add(Integer.toString(rs.getInt(1)));
                 V.add(Integer.toString(rs.getInt(2)));
                 V.add(rs.getString(3));
                 V.add(rs.getString(4));
                 V.add(rs.getString(5));
                 V.add(Integer.toString(rs.getInt(6)));
                 
             }
             
             
         } 
         catch (Exception e) 
         {
             
         }
         
         return V;
     }
    
     
     public List<String> ShowProjectDetailsManager(String Name,List<String> V)
     {
         try 
         {
             String s=("select * from Project where ProjectManager = \'"+Name+"\'");
             ResultSet rs=stmt.executeQuery(s);
             V=new ArrayList<>();
             
             while(rs.next())
             {
                 V.add(Integer.toString(rs.getInt(1)));
                 V.add(Integer.toString(rs.getInt(2)));
                 V.add(rs.getString(3));
                 V.add(rs.getString(4));
                 V.add(rs.getString(5));
                 V.add(Integer.toString(rs.getInt(6)));
                 
             }
             
             
         } 
         catch (Exception e) 
         {
             
         }
         
         return V;
     }
    

    public  Boolean  IssueDonation(int Bid)
     {
         String inc=null;
         try 
         {
            String s=("select * from Beneficiary where B_ID ="+Bid);
            ResultSet rs=stmt.executeQuery(s);
            
            while(rs.next())
            {
                inc=Integer.toString(rs.getInt(9));
            }
         }
         
         catch (Exception e) 
         {
             System.out.println(e);
         }
         int store=0;
         int id=0;
         int temp=Integer.parseInt(inc);
         boolean flag=false;
         int f=0;
         try 
         {
            String d=("select * from Fund where cash >= "+temp);
            ResultSet rs1=stmt.executeQuery(d);
            
            while(rs1.next() && f==0)
            {
                store=rs1.getInt(2);
                System.out.println(store);
                id=rs1.getInt(1);
                System.out.println(id);
                f=1;
            }
            
         } 
        
         catch (Exception e) 
         {
             System.err.println(e);
         }
         try 
         {
             String z="update Fund set Cash ="+(store-Integer.parseInt(inc))+"where d_id = "+id+" and cash = "+store;
             int rs=stmt.executeUpdate(z);
             int rs1=stmt.executeUpdate("update Beneficiary set RequiredMoney="+0+"where B_ID ="+Bid);
             flag=true;   
             String q="insert into donate values ("+id+","+Bid+")";
             int rs2=stmt.executeUpdate(q);
             
         } 
         catch (Exception e) 
         {
             System.err.println(e);
         }
         
         return flag;
     }
    
//    public boolean Issue(int Bid)
//    {
//        try 
//        {
// 
//            String query = "{?=CALL dbo.Money(?)}";
//            java.sql.CallableStatement stmt = con.prepareCall(query);
//           stmt.setInt(1, Bid);
//           Boolean rs=stmt.execute();
//           
//           
//           
//            
//            
//        } catch (Exception e)
//        {
//            System.out.println(e);
//        }
//      
//        return true;
//    }
    
    
    
    public List<String> ReturnBeneficiaryID(List<String> V)
    {
        V=new ArrayList<>();
        try 
        {
            ResultSet rs=stmt.executeQuery("select * from selected");
            while(rs.next())
            {
                V.add(Integer.toString(rs.getInt(1)));
            }
        } 
        catch (Exception e) 
        {
            System.err.println(e);
        }
        return  V;
    }
    
    
    public List<String> ReturnDonorList(List<String> V)
    {
        V=new ArrayList<>();
        
        try 
        {
            String s="select * from Donor";
            ResultSet rs=stmt.executeQuery(s);
            
            while(rs.next())
            {
                V.add(Integer.toString(rs.getInt(2)));
            }
            
        } 
        catch (Exception e)
        {
            System.err.println(e);
        }
        
        
        return V;
    }
    
    
     public List<String> ReturnDonorInfo(int did,List<String> V)
     {
         V=new ArrayList<>();
         try 
         {
             ResultSet rs=stmt.executeQuery("select * from Donor where D_ID = "+ did);
             while(rs.next())
             {
                 V.add(Integer.toString(rs.getInt(1)));
                 V.add(Integer.toString(rs.getInt(2)));
                 V.add((rs.getString(3)));
                 V.add((rs.getString(4)));
             }
         } 
         catch (Exception e) 
         {
             System.err.println(e);
         }
         return V;
         
     }
     
     public List<String> ReturnDonationOfDonor(int did,List<String> V)
     {
        V=new ArrayList<>();
        int sum=0;
         try 
         {
             ResultSet rs=stmt.executeQuery("select * from Fund where d_id ="+did);
             
             while(rs.next())
             {
                 V.add(Integer.toString(rs.getInt(2)));
                 sum=sum+rs.getInt(2);
                 V.add(rs.getString(3));
                 V.add(rs.getString(4));
             }
             V.add(Integer.toString(sum));
             
         } catch (Exception e) 
         {
             System.out.println(e);
         }
         
         return V;
     }
     
    
     public List<String> ReturnProjectinfo(int did,List<String> V)
     {
         V=new ArrayList<>();
         try 
         {
             String s1="select P.Team_ID,P.P_ID,P.Name_P,P.Cnic_ProjectManager,P.RequiredBudget from Donor d join Project P on d.p_id=P.P_ID where d.D_ID ="+did;
             ResultSet rs=stmt.executeQuery(s1);
             int sum=0;
             while(rs.next())
             {
                V.add(Integer.toString(rs.getInt(1)));
                V.add(Integer.toString(rs.getInt(2)));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                V.add(Integer.toString(rs.getInt(6))); 
                sum=sum+1;
             }
             V.add(Integer.toString(sum));
             
         } 
         catch (Exception e) 
         {
             
         }
         return V;
     }
     
     
     public List<String> ReturnBeneficiaryOfProject(int bid,List<String> v)
     {
         v=new ArrayList<>();
         try 
         {
             ResultSet rs=stmt.executeQuery("select B.B_ID,B.Name_B,B.Cnic_B,B.Adress,B.PhoneNo,B.dob,B.Income from Beneficiary B where p_id="+bid);
              while(rs.next())
              {
                  v.add(Integer.toString(rs.getInt(1)));
                  v.add(rs.getString(2));
                  v.add(rs.getString(3));
                  v.add(rs.getString(4));
                  v.add(rs.getString(5));
                  v.add(rs.getString(6));
                  v.add(Integer.toString(rs.getInt(7)));
              }
         } 
         catch (Exception e) 
         {
             System.err.println(e);   
         }
         return v;
     }
     
     
     public List<String> ReturnDonorOfGivenProject(int pid,List<String> V)
     {
         V=new ArrayList<>();
         try 
         {
            String s="select D.Name_D,D.Cnic_D from Project P join Donor D on P.P_ID=D.p_id where P.P_ID ="+pid;   
            ResultSet rs=stmt.executeQuery(s);
            
            while(rs.next())
            {
                V.add(rs.getString(1));
                V.add(rs.getString(2));
            }
         } 
         catch (Exception e) 
         {
             System.err.println(e);
         }
         return V;
     }
     
     
     public List<String> ReturnBeneficiaryList(List<String> V)
     {
            V=new ArrayList<>();
         try 
         {
                 String s="select * from Beneficiary ";
                 ResultSet rs=stmt.executeQuery(s);
                 while(rs.next())
                 {
                     V.add(Integer.toString(rs.getInt(1)));
                 }
          } 
         catch (Exception e) 
         {
             System.err.println(e);
         }
         
         return V;
     }
     
     
     public List<String> ReturnBeneficiaryProjectList(int bid,List<String> V)
     {
         V=new ArrayList<>();
         try 
         {
             String s="select P.Name_P,P.Cnic_ProjectManager,ProjectManager from Beneficiary B join Project P on B.p_id=P.P_ID where B.B_ID = "+bid;
             ResultSet rs=stmt.executeQuery(s);
             while(rs.next())
             {
                 V.add(rs.getString(1));
                 V.add(rs.getString(2));
                 V.add(rs.getString(3));
             
             }
             
         } 
         catch (Exception e)
         {
             System.err.println(e);
             
         }
         return V;
     }
    
     public List<String> ReturnDonorOfBeneficiary(int bid,List<String> V)
     {
        V=new ArrayList<>();
         try 
         {
             String s="select D.D_ID,D.Name_D,Cnic_D from donate S join donor D on D.D_ID=S.d_id where S.b_id ="+bid;
             ResultSet rs=stmt.executeQuery(s);
             while(rs.next())
             {
                 V.add(Integer.toString(rs.getInt(1)));
                 V.add(rs.getString(2));
                 V.add(rs.getString(3));
             }
         } 
         catch (Exception e) 
         {
             System.err.println(e);
         }
         return V;
     }
     
     List<String> ReturnProjectOfBeneficiary(int bid,List<String> V)
     {
         V=new ArrayList<>();
         try 
         {
             String s="Select P.Team_ID,P.P_ID,P.Name_P,P.ProjectManager,P.Cnic_ProjectManager,P.RequiredBudget from Beneficiary B join Project P on B.p_id=P.P_ID where B.B_ID = "+bid;
             ResultSet rs=stmt.executeQuery(s);
             
             while(rs.next())
             {
                 V.add(Integer.toString(rs.getInt(1)));
                 V.add(Integer.toString(rs.getInt(2)));
                 V.add(rs.getString(3));
                 V.add(rs.getString(4));
                 V.add(rs.getString(5));
                 V.add(Integer.toString(rs.getInt(6)));
             }
             
         } 
         catch (Exception e)
         {
             System.err.println(e);
         }
         
         return V;
     }
     
     
}

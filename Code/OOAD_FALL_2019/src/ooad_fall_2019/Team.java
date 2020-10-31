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
public class Team
{
     List<Person> V_Team;
    int T_ID;
    int vid;
    
    

    public Team()
    {
        this.T_ID = 0;
        this.V_Team=new ArrayList<>();
    }
    
    void addTeamVolunteer(Person V)
    {
        V_Team.add(V);
    }
    
    
}

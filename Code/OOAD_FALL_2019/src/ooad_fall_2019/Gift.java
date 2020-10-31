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
public class Gift extends Fund
{
    int GiftId;
    String gift;
    int amount1;

    public Gift(int GiftId, String gift, int amount1) {
        this.GiftId = GiftId;
        this.gift = gift;
        this.amount1 = amount1;
    }
    
    void PrintFundinfo()
    {
        System.out.println(GiftId);
        System.out.println(gift);
        System.out.println(amount1);
        
        
    }
   
    
    
}


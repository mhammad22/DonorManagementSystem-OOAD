/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooad_fall_2019;


public class Cash extends Fund 
{
    int amountFund;
    int CashID;

    public Cash(int amountFund,int CashID) 
    {
        this.amountFund = amountFund;
        this.CashID=CashID;
    }
    
    void PrintFundinfo()
    {
        System.out.println(amountFund);
        System.out.println(CashID);
    }
    
    
}
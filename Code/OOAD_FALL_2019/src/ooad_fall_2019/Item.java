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
public class Item extends Fund
{
    int ItemId;
  String item;
  int amount2;

    public Item(int ItemId, String item, int amount2) {
        this.ItemId = ItemId;
        this.item = item;
        this.amount2 = amount2;
    }

  void PrintFundinfo()
  {
      System.out.println(ItemId);
      System.out.println(item);
      System.out.println(amount2);
        
        
        
  }
    
}

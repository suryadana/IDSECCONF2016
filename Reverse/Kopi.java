/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kopi;

import java.io.PrintStream;
import java.util.Stack;
// argument untuk dapetin flagnya : 1-1-2-3-5-8-13-21-34-55-89-144-233-377-610-987-1597-2584-4181-6765
/**
 *
 * @author pendekar_langit
 */
public class Kopi {
    private StringBuilder flag = new StringBuilder();
  
  private String getFlag()
  {
    return this.flag.toString();
  }
  
  private static int[] buff = { 103, 109, 99, 106, 128, 81, 89, 126, 141, 156, 163, 241, 351, 474, 715, 1097, 1664, 2668, 4251, 6890 };
  
  private boolean checkPassword(String paramString)
  throws Exception
  {
      System.out.println(paramString);
    String[] arrayOfString1 = paramString.split("-");
    Stack localStack1 = new Stack();
    Stack localStack2 = new Stack();
    for (String str : arrayOfString1) {
        System.out.println(str);
        System.out.println(Integer.valueOf(Integer.parseInt(str)));
      localStack1.push(Integer.valueOf(Integer.parseInt(str)));
    }
//    System.out.print(localStack1.toString());
    int i = ((Integer)localStack1.pop()).intValue();
//    System.out.println(i);
    localStack2.push(Integer.valueOf(i));
//    System.out.print(((Integer)localStack1.pop()).intValue());
    int pop11 = ((Integer)localStack1.pop()).intValue();
    localStack2.push(Integer.valueOf(pop11));
    while (!localStack1.empty())
    {
      int pop12 = ((Integer)localStack1.pop()).intValue();
      if (pop11 != i - pop12) {
          System.out.println("tes");
        return false;
      }
      localStack2.push(Integer.valueOf(pop12));
      i = pop11;
      pop11 = pop12;
    }
    if (i * (pop11 / i) != 1) {
       System.out.println("tes");
      return false;
    }
    for (int index = 0; index < buff.length; index++)
    {
      buff[index] -= ((Integer)localStack2.pop()).intValue();
      this.flag.append((char)buff[index]);
    }
    return true;
  }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] paramArrayOfString) {
        // TODO code application logic here
        if (paramArrayOfString.length != 1)
    {
      System.out.println("Usage: Kopi <password>");
      return;
    }
    System.out.println("Checking ... " + paramArrayOfString[0]);
    Kopi localKopi = new Kopi();
    boolean bool = false;
    try
    {
      bool = localKopi.checkPassword(paramArrayOfString[0]);
    }
    catch (Exception localException)
    {
      System.out.println("Invalid password");
      return;
    }
    if (bool) {
      System.out.println("The flag is: " + localKopi.getFlag());
    } else {
      System.out.println("Invalid password");
    }
    }
    
}

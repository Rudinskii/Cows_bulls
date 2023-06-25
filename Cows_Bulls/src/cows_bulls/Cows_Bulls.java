
package cows_bulls;

import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class Cows_Bulls {
    
    
    

    
    public static void main(String[] args) {
        
        
        int []array1 = new int[4];
        Random random = new Random();
        for (int k=0; k<4; k++){
          array1[k] = random.ints(0, 9)
      .findFirst()
      .getAsInt();  
        }
        
        
        
        
        
    
        
        int attempt =1;
        int bulls=0;
        
        
        
        while (bulls!=4) {
          try(FileWriter writer = new FileWriter("gameRez.txt", true)){
            
            
            
          bulls=0;
          int cows=0;
        
        Scanner sc = new Scanner(System.in);
        String []str = sc.next().split("");
        int []array2 = new int [str.length];
for (int k=0; k<str.length; k++ ){
 array2[k] = Integer.parseInt(str[k]);
   }
       
       
       
       for (int i=0; i<array1.length; i++){
           for (int j=0; j<array2.length; j++){
             if (i==j && array1[i]==array2[j]){
                 bulls++;
             }   
             else if (array1[i]==array2[j]){
                 cows++;
             }
           }
    }
        System.out.println("быки="+bulls);
            System.out.println("коровы="+ cows);  
          System.out.println("Количество попыток = "+ attempt);  
         
       String text = "быки="+bulls +"\n" + "коровы="+ cows +"\n" + "Количество попыток = "+ attempt +"\n" ;
          writer.write(text);
           attempt++;
             writer.flush();
        }
         catch(IOException ex){  System.out.println(ex.getMessage());}
       
          } 
       
        
        
        
    
        
        
         
        
        
       
        
        
}
}
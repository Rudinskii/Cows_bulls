package cows_bulls;

import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.util.Random;
import java.time.Instant;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Cows_Bulls {
    public static String printCows(int count){       // вывод количества коров
      String text ="";
       if  (count ==0) {text = " коров";}
         else if (count ==1){text =" корова";}
         else if (count >1){text = " коровы";}
           return count+ text; 
    }
    public static String printBulls(int count){    // вывод количества быков
        String text ="";
        if  (count ==0){text = " быков";}
       else if (count ==1){text = " бык";}
       else if (count >1){text = " быка";} 
           return count+ text;
    }
    public  int[] numbGenerate(){         // сгенерирован массив 4 цифр 
        Set<Integer> generated = new LinkedHashSet<>() ;
        Random random = new Random();     
while (generated.size() < 4) {
    int [] array = random.ints(1, 0, 10).toArray();  
        int count = array[0];
generated.add(count);
}
        return generated.stream()
                            .mapToInt(Integer::intValue)
                            .toArray();       
    }
 public static int findAttempt(String path) { // считывание из файла номера игры
         StringBuilder sb = new StringBuilder();
        File file = new File(path);
          if (file.length() == 0)
              return 1;
          else {
           try (Scanner scan = new Scanner(new File(path))) {
           
           while (scan.hasNextLine()) {
                sb.append(scan.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.printf("File [%s] is not found.\n", path);
        }
        String[] array = sb.toString().split("\n");
             
       if (array[array.length-1].startsWith("Строка была угадана")) {
             String []array1 = array[array.length-3].split("№| ");
          int count = Integer.parseInt(array1[2]);
          return count+1;}
   
        else {
          String []array1 = array[array.length-2].split("№| ");
          int count = Integer.parseInt(array1[2]);
          return count;
       }
          }   
    }
    public static void main(String[] args) {    
     SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String filePath = "gameRez.txt";
        String date = dateFormat.format(Calendar.getInstance().getTime());
        Cows_Bulls cowsBulls = new Cows_Bulls();
        int []array3 = cowsBulls.numbGenerate();
        Scanner sc = new Scanner(System.in);
        Cows cow = new Cows();       
        Bulls bull = new Bulls();
        int attempt =findAttempt("gameRez.txt");
        int rez1;
        int rez2 =0;
     
        while (rez2!=4) {
          try(FileWriter writer = new FileWriter(filePath, true)){  
         String []str = sc.next().split(""); //считывание строки (четырех чисел)  
        int []array2 = new int [str.length]; 
        
  for (int k=0; k<str.length; k++ ){
       array2[k] = Integer.parseInt(str[k]);
    }  
    rez1 = cow.fundCows(array3, array2); // кол-во коров 
    rez2 = bull.fundBulls(array3, array2); // кол-во быков

    System.out.print("Game №" + attempt + " " + date + " Загаданная строка ");
        Arrays.stream(array3).forEach(System.out::print);
        String mass1 = Arrays.stream(array2)
                              .mapToObj(String::valueOf)
                              .reduce((x, y) -> x + y).get();
        String mass2 = Arrays.stream(array3)
                              .mapToObj(String::valueOf)
                              .reduce((x, y) -> x + y).get();
          System.out.println(" ");
          System.out.println( printCows(rez1));  
          System.out.println( printBulls(rez2));
         
        String text = "Game №" + attempt + " " + date + " Загаданная строка "+ 
                  mass2 +"\n" + "    Запрос: " + mass1 +" Ответ: "+ 
                  printCows(rez1) + " "+printBulls(rez2) + "\n";
        if (rez2==4){
              text +="Строка была угадана за "+attempt + " попыток"+"\n";
          attempt++; 
          }          

           writer.write(text);
           writer.flush();
        }
          catch(IOException ex){System.out.println(ex.getMessage());}
        }
          } 
}

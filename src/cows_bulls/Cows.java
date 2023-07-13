package cows_bulls;
import java.util.Arrays;

public class Cows {
    public Cows() {}
    
    public int fundCows(int array1[], int array2[]){
        int cows =0;
        for (int i=0; i<array2.length; i++){
           for (int j=0; j<array1.length; j++){
               if (array2[i]==array1[j] && j!=i){
                 cows++;
               break;
             }
          continue;
            }
    }
    return cows;
    
}
}

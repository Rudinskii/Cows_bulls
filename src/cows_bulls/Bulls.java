package cows_bulls;
public class Bulls {
    public Bulls() {}
    public int fundBulls(int array1[], int array2[]){
        int bulls =0;
        for (int i=0; i<array2.length; i++){
           for (int j=0; j<array1.length; j++){
               if (array2[i]==array1[j] && i==j){
                bulls++;
             }
           }
    }
    return  bulls;  
}    
}

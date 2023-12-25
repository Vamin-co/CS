/*
 * Vandan Amin
 * Oct 11 2023
 * Lab 3 
 */

import java.util.*;

public class LabAssingment3{
   /*Sample problem recursive*/
   public static boolean recSample(String str){
      if(str.length() == 0 || str.length() == 1){
         return true;
      }
      
      if(str.charAt(0) == str.charAt(str.length()-1) ){
         return recSample(str.substring(1, str.length()-1));
      }
      
      return false;     
   }
   
   
   /*Sample problem iterative*/
   public static boolean itrSample(String str){
   
      for(int i=0, j=str.length()-1; i<str.length()/2; i++, j--){
         if( (str.charAt(i)) != (str.charAt(j)) ){
            return false;
         }
      }
      
      return true;
   }
   /*-------------------------------*/


   /*Recursive function #1*/
   public static int recFunc1(int x){
      if(x==0 || x==1){
         return x;
      }
      
      return x + recFunc1(x-1);
   }
   
   
   /*Iterative function #1*/
   public static int itrFunc1(int x){
      int result = 0;
      for (int i = 0; i <= x; i++) {
          result += i;
      }
      return result; 
   }
   /*-------------------------------*/
   
   
   /*Recursive function #2*/
   public static boolean recFunc2(int[] arr, int i, int j){
      if(j <= i){
         return true; 
      }
      
      if(arr[i] != arr[j]){
         return false;
      }
      
      return recFunc2(arr,i+1, j-1);    
   }
   
   
   /*Iterative function #2*/
   public static boolean itrFunc2(int[]arr, int i, int j){
      while (j > i) {
         if (arr[i] != arr[j]) {
             return false;
         }
         i++;
         j--;
     }
     return true;
   }
   /*-------------------------------*/
   
   
   
   /*Recursive function #3*/
   public static boolean recFunc3(int[] arr, int i, int j){
        if(arr.length <= 1 || i == j){
            return false;
        }
        
        if(arr[i] == arr[i+1]){
            return true;
        }
        
        return recFunc3(arr, i+1, j);
   }
   
   
   /*Iterative function #3*/
   public static boolean itrFunc3(int[]arr, int i, int j){
      while (i < j) {
         if (arr[i] == arr[i + 1]) {
             return true;
         }
         i++;
     }
     return false;
   }
   /*-------------------------------*/
   
   
   /*Recursive function #4*/
   public static int recFunc4(int i, int j){
       if(j <= 1){
           return i;
       }
       
       return i + recFunc4(i, j-1);
   }
   
   
   /*Iterative function #4*/
   public static int itrFunc4(int i, int j){
      int result = 0;
      int x = 0;
      for (; x < j; x++) {
         result += i;
      }
      return result;
   }
   /*-------------------------------*/
   
   
   /*Recursive function #5*/
   public static int recFunc5(int i){
       if(i == 0){
          return 0;
       }
       
       return (i%10) + recFunc5(i/10);
        
   }
   
   
   /*Iterative function #5*/
   public static int itrFunc5(int i){
      int result = 0;
      while (i > 0) {
          result += i % 10;
          i /= 10;
      }
      return result;
   }
   /*-------------------------------*/
   
   
   
   
   /*     Some simple tests
   Do not modify the code below*/
   public static void main(String[] args){
      Random rand = new Random();
      
      
      /*Running sample function*/           
      System.out.println("Running sample function :");
      String[] strs = {"wildcats", "kayak", "civic", "school", "abcdcba"};
      
      for(int i=0; i<strs.length; i++){
         boolean expected = recSample(strs[i]);
         System.out.println("  run # "+(i+1)+":\n"+"    input : "+strs[i]+"       output : "+expected);
         
         boolean result = itrSample(strs[i]);
         if(result != expected){
            System.out.println("    test : FAILED");
         }else{
            System.out.println("    test : PASSED");
         }
      }
      /*--------------------------------------*/

      
      
      /*Running function #1*/           
      System.out.println("\nRunning function #1 :");
      
      for(int i=1; i<=5; i++){
         int randNum = rand.nextInt(11);
         int expected = recFunc1(randNum);
         System.out.println("  run # "+i+":\n"+"    input : "+randNum+" output : "+expected);
         
         int result = itrFunc1(randNum);
         if(result != expected){
            System.out.println("    test : FAILED");
         }else{
            System.out.println("    test : PASSED");
         }
      }
      /*--------------------------------------*/
      
      
       /*Running function #2*/           
      {System.out.println("\nRunning function #2 :");
      int[][] arrays = {{4, 6, 2, 2, 6, 4}, {1, 2, 4, 5, 4, 7, 2}, {1, 2, 1}, {9, 5, 3, 3, 5, 9}, {4, 3, 2}};
      int[][] inputs = {{1, 3}, {2, 4}, {0, 2}, {0, 4}, {1, 1}};
      
      for(int i=0; i<arrays.length; i++){
         boolean expected = recFunc2(arrays[i], inputs[i][0], inputs[i][1]);
         System.out.println("  run # "+(i+1)+":\n"+"    input : "+Arrays.toString(arrays[i])+
                              ", i="+inputs[i][0]+", j="+inputs[i][1]+"   output : "+expected);
         
         boolean result = itrFunc2(arrays[i], inputs[i][0], inputs[i][1]);
         if(result != expected){
            System.out.println("    test : FAILED");
         }else{
            System.out.println("    test : PASSED");
         }         
      }}
      /*--------------------------------------*/
      
      
      /*Running function #3*/           
      {System.out.println("\nRunning function #3 :");
      int[][] arrays = {{4, 6, 2, 2, 6, 4}, {1, 2, 4}, {1, 2, 1, 1}, {1, 2, 3, 2, 1}, {9, 9, 9, 9}};
      int[][] inputs = {{1, 4}, {0, 2}, {1, 3}, {0, 4}, {1, 3}};
      
      for(int i=0; i<arrays.length; i++){
         boolean expected = recFunc3(arrays[i], inputs[i][0], inputs[i][1]);
         System.out.println("  run # "+(i+1)+":\n"+"    input : "+Arrays.toString(arrays[i])+
                              ", i="+inputs[i][0]+", j="+inputs[i][1]+"   output : "+expected);
         
         boolean result = itrFunc3(arrays[i], inputs[i][0], inputs[i][1]);
         if(result != expected){
            System.out.println("    test : FAILED");
         }else{
            System.out.println("    test : PASSED");
         }         
      }}
      /*--------------------------------------*/
      
      
      /*Running function #4*/           
      {System.out.println("\nRunning function #4 :");
      
      for(int i=1; i<=5; i++){
         int randNum1 = rand.nextInt(10)+1;
         int randNum2 = rand.nextInt(10)+1;
         int expected = recFunc4(randNum1, randNum2);
         System.out.println("  run # "+i+":\n"+"    input : i="+randNum1+", j= "+randNum2+" output : "+expected);
         
         int result = itrFunc4(randNum1, randNum2);
         if(result != expected){
            System.out.println("    test : FAILED");
         }else{
            System.out.println("    test : PASSED");
         }
      }}
      /*--------------------------------------*/
      
      
      /*Running function #5*/           
      {System.out.println("\nRunning function #5 :");
      
      for(int i=1; i<=5; i++){
         int randNum = rand.nextInt(1000)+1;
         int expected = recFunc5(randNum);
         System.out.println("  run # "+i+":\n"+"    input : i="+randNum+" output : "+expected);
         
         int result = itrFunc5(randNum);
         if(result != expected){
            System.out.println("    test : FAILED");
         }else{
            System.out.println("    test : PASSED");
         }
      }}
      /*--------------------------------------*/

     
   }

}
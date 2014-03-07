/**
  Gerson Lobos

*/
import java.io.*;
import java.lang.*;
import java.util.*;



public class Sorting {
    
    
     public static void main(String[ ] args)
       {
         final String spaces = " "; // A String of two blanks
          int i;  
          String line= "**************";
          
            Random r = new Random();
            int arr[] = new int[100];
            int arr1[] = new int[100];
            int arr2[] = new int[100];
            int arr3[] = new int[100];
            int arr4[] = new int[]{14,5,23,19,15,18,20,9,14,7,1,12,7,15,18,9,20,8,13};
            int arr5[] = new int[100];
            for(int c = 0; c < 100; c++)
            {
               arr[c] = r.nextInt(1000) + 1;
               arr1[c]=arr2[c]=arr3[c]= /*arr4[c]=*/ arr5[c]=arr[c];
            }
        
          // Print the array before sorting:
            System.out.print("\n");
            System.out.print("\n");
          System.out.println(line+"Original array:"+line);
          for (i = 0; i < arr.length; i++)
             System.out.print(arr[i] + spaces);
          System.out.println("\n");
          
          
          
          System.out.print(line+" SELECTIONSORT"+line+"\n");
          selectionsort(arr1, 0, arr.length);
          for (i = 0; i < arr.length; i++)
             System.out.print(arr1[i] + spaces);
          System.out.println( );
         System.out.println("\n");
         
         
          System.out.print(line+"INSERTIONSORT"+line +"\n");
          insertionsort(arr2, 0, arr.length);
         
          for (i = 0; i < arr2.length; i++)
             System.out.print(arr2[i] + spaces);
          System.out.println("\n");
          
          
          System.out.print(line+" MERGESORT" +line+"\n");
          mergesort(arr3, 0, arr3.length);
          
          for (i = 0; i < arr3.length; i++)
          System.out.print(arr3[i] + spaces);
          System.out.println("\n");
          
          System.out.print(line+"QUICKSORT"+line+"\n" );
          quicksort(arr4, 0, arr4.length-1);
          System.out.print("\n");

          for (i = 0; i < arr4.length; i++)
           System.out.print(arr4[i] + spaces);
          System.out.println("\n");
          
         System.out.print(line+" HEAPSORT"+line+"\n");
          heapsort(arr5);
          for (i = 0; i < arr5.length; i++)
             System.out.print(arr5[i] + spaces);
          System.out.println("\n");
       }
       
      
     // Heap sort
     public static void heapsort(int[ ] data)
       {
           int count = data.length;
           
           makeHeap(data, count);
      
           int end = count - 1;
         
          while(end > 0)
          {
              int temp = data[end];
              data[end] = data[0];
              data[0]= temp;
              
              reheapifyDown(data, 0, end -1);
              end--;
          }
     }
       
      
       private static void makeHeap(int[ ] data, int n)
       {
           int start = (n -2)/2;
           
           while(start >=  0){   
               reheapifyDown( data , start, n-1);
               start--;
           }
       }
       
             
       
       private static void reheapifyDown(int[ ] data, int str, int end)
       {
        int root = str;
        
        while((root * 2 + 1) <= end){
           int child = root * 2 +1;
        if(child + 1 <= end  && data[child] < data[child +1])
            child = child +1;
        if(data[root] < data[child])
        {
            
            int temp= data[root];
            data[root] = data[child];
            data[child]= temp;
            root = child;
        }else
             return; 
           
        }
       }
       
    // Insertion sort
      
       public static void insertionsort(int[ ] data, int first, int n)
       {
          int i, j;   // Loop control variables
          int entry;  // The element that is currently being inserted
             
          for (i = 1; i < n; i++)
          {
             entry = data[first+i];
             for (j = first+i; (j>first) && (data[j-1] > entry); j--) 
                data[j] = data[j-1]; 
             data[j] = entry;   
          }
      } 
       
       // selection sort
      
       public static void selectionsort(int[ ] data, int first, int n)
       {
          int i, j; // Loop control variables
          int big;  // Index of largest value in data[first]...data[first+i]
          int temp; // Used during the swapping of two array values
          for (i = n-1; i > 0; i--)
          {  
             // Calculate big as the index of the largest value in data[first]...data[first+i]:
             big = first;
             for (j = first+1; j <= first+i; j++)
                if (data[big] < data[j])
                   big = j;
          
             // swap data[first+i] with data[big]:
             
             temp = data[first+i];
             data[first+i] = data[big];
             data[big] = temp;
          }
       } 
       
       public static void displayArray(int [] array,int pivot,int left,int right){
    	   for(int i=0;i<array.length;++i){
    	System.out.print(array[i]+" ");
    	   }
    	   System.out.println(" pivot="+pivot+" l="+left+" r="+right);
       }//end pf display array
       

       public static void quicksort(int[ ] data, int left, int right)
       {

    	int index = partition(data,left,right);
    	if(left< index-1)
    		quicksort(data,left,index-1);
    	if(index <right)
    		quicksort(data,index,right);
       }
       //partition is part pf quicksort
       private static int partition(int[ ] data, int first, int n)
       {
    	   int left=first;
    	   int right=n;
           int pivot = data[(first+n)/2];
           int temp;
           displayArray(data,pivot,left,right);
           while(left <= right)
           {
        	   while(data[left] <pivot)
        		   left++;
        	   
        	   while(data[right] > pivot)
        		   right--;
        	   
        	   if(left <= right)
        	   {
        		   temp=data[left];
        		   data[left]=data[right];
        		   data[right]=temp;
        		   left++;
        		   right--;
        		   
        	   }
           };//end first while
          
        	     
           return left;
       }//end class
     
       public static void mergesort(int[ ] data, int first, int n)
       {
          int n1; // Size of the first half of the array
          int n2; // Size of the second half of the array

          if (n > 1)
          {
             // Compute sizes of the two halves
             n1 = n / 2;
             n2 = n - n1;

             mergesort(data, first, n1);      // Sort data[first] through data[first+n1-1]
             mergesort(data, first + n1, n2); // Sort data[first+n1] to the end

             // Merge the two sorted halves.
             merge(data, first, n1, n2);
          }
       } 
      
       private static void merge(int[ ] data, int first, int n1, int n2)
      
       {
          int[ ] temp = new int[n1+n2]; // Allocate the temporary array
          int copied  = 0; // Number of elements copied from data to temp
          int copied1 = 0; // Number copied from the first half of data
          int copied2 = 0; // Number copied from the second half of data
          int i;           // Array index to copy from temp back into data

          // Merge elements, copying from two halves of data to the temporary array.
          while ((copied1 < n1) && (copied2 < n2))
          {
             if (data[first + copied1] < data[first + n1 + copied2])
                temp[copied++] = data[first + (copied1++)];
             else
                temp[copied++] = data[first + n1 + (copied2++)];
          }

          // Copy any remaining entries in the left and right subarrays.
          while (copied1 < n1)
             temp[copied++] = data[first + (copied1++)];
          while (copied2 < n2)
             temp[copied++] = data[first + n1 + (copied2++)];

          // Copy from temp back to the data array.
          for (i = 0; i < n1+n2; i++)
             data[first + i] = temp[i];
       }
       
}

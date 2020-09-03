package com.example;

import java.util.Scanner;

public class HCF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HCF hcf = new HCF();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the length of the array:");
	      int length = sc.nextInt();
	      int [] myArray = new int[length];
	      System.out.println("Enter the elements of the array:");

	      for(int i=0; i<length; i++ ) {
	         myArray[i] = sc.nextInt();
	      }
	      
		   hcf.highestCommonFactor(myArray);
		
	}
	public int highestCommonFactor(int[] numbers) {


		  int min = numbers[0],count = 1,hcf = 1;
		  boolean flage = false;
		  
		  System.out.println("The array is:- ");
		  
		  for(int i = 0; i < numbers.length; i++)
		  {
		   System.out.print(numbers[i] + "\t");
		  }
		  
		  for(int i = 0; i < numbers.length; i++)
		  {
		   if(numbers[i] < min)
		    min = numbers[i];
		  }
		  
		  for(int i = 1; i <= min; i++)
		  {
		   for(int j = 0; j < numbers.length; j++)
		   {
		    if(numbers[j] % i == 0)
		    {
		     count++;
		     if(count == numbers.length)
		     {
		      hcf = hcf * i;
		     }
		    }
		   }
		   count = 0;
		  }
		  
		  System.out.println("HCF is:- " + hcf);
		 
		  return hcf;
		}

}

package amazonGeeks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MaximumHistogramArea {
public static void main(String[] args) {
	
	Scanner obj=new Scanner(System.in);
	int t=obj.nextInt();
	
	while(t>=1)
	{
		
		int n=obj.nextInt();
		int ar[]=new int[n];
		
		for(int i=0;i<n;i++)
			ar[i]=obj.nextInt();
		
		int left[]=new int[n];
		int right[]=new int[n];
		
		//O(N^2) METHOD #####BRUTE FORCE
		
		/*
		left[0]=0;
		for(int i=1;i<n;i++)
		{
		int count=0;
		int j=i-1;
		while(j>=0&&ar[j]>=ar[i])
		{
			count++;
			j--;
		}
		left[i]=count;
		}
		
		right[n-1]=0;
		for(int i=n-2;i>=0;i--)
		{
		int count=0;
		int j=i+1;
		while(j<ar.length&&ar[i]<=ar[j])
		{
			count++;
			j++;
		}
		right[i]=count;
		}
		
		//the answer
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
			if(ar[i]*(left[i]+right[i]+1)>max)
				max=ar[i]*(left[i]+right[i]+1);
			
			
		
		System.out.println(max);
		
		*/
		//O(N) method  #####USING STACKS
		
		Stack<Integer> stack=new Stack<Integer>();
		
		//left array build
		 for(int i=0;i<n;i++)
		 {
			 if(stack.isEmpty())
			 {
				 left[i]=0;
				 stack.push(i);
			 }
			 else if(ar[stack.peek()]>=ar[i])
			 {
				 int count=0;
				 while(!stack.isEmpty()&&ar[stack.peek()]>=ar[i])
				 {
					 count++;
					 count+=left[stack.peek()];
					 stack.pop();
				 }
				 left[i]=count;
				 stack.push(i);
			 }
			 else 
			 {
				 left[i]=0;
				 stack.push(i);
			 }
		 }
		
		 //right stack build
		 
		 stack=new Stack<Integer>();
		 for(int i=n-1;i>=0;i--)
		 {
			 if(stack.isEmpty())
			 {
				 right[i]=0;
				 stack.push(i);
			 }
			 else if(ar[stack.peek()]>=ar[i])
			 {
				 int count=0;
				 while(!stack.isEmpty()&&ar[stack.peek()]>=ar[i])
				 {
					 count++;
					 count+=right[stack.peek()];
					 stack.pop();
				 }
				 right[i]=count;
				 stack.push(i);
			 }
			 else 
			 {
				 right[i]=0;
				 stack.push(i);
			 }
		 }
		 
		
		 //build the answer
		 int max=Integer.MIN_VALUE;
		 
		 for(int i=0;i<n;i++)
			 if((left[i]+right[i]+1)*ar[i]>max)
				 max=(left[i]+right[i]+1)*ar[i];
		 
		 System.out.println(max);
		 
		t--;
	}
	
}
}

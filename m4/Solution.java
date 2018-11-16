package m4;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import sun.misc.Queue;

class Matrix
{
	 int a[][];
	 int [] in;
		ArrayList<Integer> arr=new ArrayList<Integer>();
	ArrayList<Integer> topsort=new ArrayList<Integer>();
	 static int j1=0;
	 static int e;
	 Queue<Integer>q=new Queue<Integer>();
	 
	 
	 public Matrix (int s1) throws IOException
	 {
	
		 super();
		 this.e=s1;
		 in=new int[s1];
		
		
			a = new int[s1][s1];
			for(int i = 0;i<s1;i++)
			{
				for(int j = 0;j<s1;j++)
				{
					a[i][j]=0;
				}
			}
	 } 
	public void insert(int n,int m)
	{
		a[n][m]=1;
		
	}
	public void display()
	{
		for(int i = 0;i<e;i++)
		{
			
			
			System.out.print(topsort.get(i)+" ");
			
		}
	}
	public void topologicalsort() throws InterruptedException
	{
		int i,k;
		for (i=0;i<e;i++) 
	     {
			in[i]=indegree(i);
			
			if(in[i]==0)
			{
			   q.enqueue(i);
			}
		}
		
		while(!q.isEmpty()) 
	     {
			k=q.dequeue();
			topsort.add(k);
			j1++;
			for (i=0;i<e;i++) 
	                 {
				if(a[k][i]==1) 
	                     {
					a[k][i]=0;
					in[i]=in[i]-1;
					if(in[i]==0)
					     q.enqueue(i);
				  }
			     }
		}
		
	}
public	int indegree(int node) 
    {
		int i,deg = 0;
		for (i = 0;i <a.length;i++)
		   if(a[i][node] == 1)
		    deg++;
		return deg;
	}

	
}
 public class Solution {
public static void main(String args[]) throws IOException, InterruptedException
{Scanner s=new Scanner(System.in);
	System.out.println("No of vertices:");
	
	int n=s.nextInt();
	System.out.println("no of dependencies");
	int m=s.nextInt();
	Matrix m1=new Matrix(n+1);
	for(int i = 0;i<m;i++)
	{
	System.out.println("enter n1,n2");
	
	int n1=s.nextInt();
	int n2=s.nextInt();
	
		if(!m1.arr.contains(n1))
		{
			m1.arr.add(n1);
			
		}
		if(!m1.arr.contains(n2))
		{
			m1.arr.add(n2);
		}
	
	m1.insert(n1, n2);
	}
	m1.topologicalsort();
	m1.display();
}
	 
}
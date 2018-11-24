package pc1;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import sun.misc.Queue;


class Graph {
	int V;
	int E;
	int[] id;
	
	boolean marked[];
     ArrayList<Integer>[] adj;
     LinkedList<Integer> queue = new LinkedList<Integer>(); 
     LinkedList<Integer> q1= new LinkedList<Integer>(); 
     Queue<Integer> q = new Queue<Integer>();
    
     @SuppressWarnings("unchecked")
	public Graph(int V)
     {
    	 this.V=V;
    	 id=new int[V];
    	 marked=new boolean[V+1];
    	 adj=(ArrayList<Integer>[])new ArrayList[V+1];
    	 for(int v=0;v<=V;v++)
    		 adj[v]=new ArrayList<Integer>();
    	 
     }
 int V()
{
	return V;
}
int E()
{
	return E;
}
Iterable<Integer> adj(int v)
{
	return adj[v];
}

void addEddge(int v,int w)
{
	E++;
	adj[v].add(w);
	adj[w].add(v);
}
void social(int i,int i1) throws InterruptedException
{	
	BFS(i,i1);
	System.out.println();
}



void display()
{
	for(int i = 0;i<V;i++)
	{
		System.out.println(q1.get(i)+1);
		
	}
}

 void BFS(int s,int i1) throws InterruptedException 
	    { 
	       int count=0;
	int l=0;
	        boolean visited[] = new boolean[V]; 
	  
	        
	        visited[s]=true; 
	        queue.add(s); 
	  
	        while (queue.size() != 0) 
	        { 
	           count=0;	            s = queue.poll(); 
	            q1.add(s);
	  
	           
	            Iterator<Integer> i = adj[s].listIterator(); 
	            while (i.hasNext()) 
	            { 
	                int n = i.next(); 
	                if (!visited[n]) 
	                {  count++;
		           
	                    visited[n] = true; 
	                    queue.add(n); 
	                   
	                } 
	            }
	            id[l]=count;
	            System.out.println(count);
	            l++;
	            
	        }
	        System.out.println(id[l-1]);
	        
	    } 

}
public class Solution {
	public static void main(String args[]) throws IOException, InterruptedException
	{
Scanner s=new Scanner(System.in);
int n=s.nextInt();
Graph g=new Graph( n);

int m=s.nextInt();

for(int i = 0;i<=n;i++)
{
	int n1=s.nextInt();
	int n2=s.nextInt();
	g.addEddge(n1-1, n2-1);
	
}

int no=s.nextInt();

for(int i=0;i<no;i++)
{
	int m1=s.nextInt();
	int m2=s.nextInt();
	g.social(m1-1,m2);
	
	
}


	}
}

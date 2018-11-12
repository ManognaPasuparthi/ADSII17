
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
/*************************************************************************
 *  Compilation:  javac Bag.java
 *  Execution:    java Bag < input.txt
 *
 *  A generic bag or multiset, implemented using a linked list.
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The <tt>Bag</tt> class represents a bag (or multiset) of 
 *  generic items. It supports insertion and iterating over the 
 *  items in arbitrary order.
 *  <p>
 *  The <em>add</em>, <em>isEmpty</em>, and <em>size</em>  operation 
 *  take constant time. Iteration takes time proportional to the number of items.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
class Bag<Item> implements Iterable<Item> {
    private int N;         // number of elements in bag
    private Node first;    // beginning of bag

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

   /**
     * Create an empty stack.
     */
    public Bag() {
        first = null;
        N = 0;
    }

   /**
     * Is the BAG empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

   /**
     * Return the number of items in the bag.
     */
    public int size() {
        return N;
    }

   /**
     * Add the item to the bag.
     */
    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }


   /**
     * Return an iterator that iterates over the items in the bag.
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

}


interface Graph {
    public int V();
    public int E();
    public void addEdge(int v, int w);
    public Iterable<Integer> adj(int v);
    public boolean hasEdge(int v, int w);
}

 class Graphs{
	private static final Object NEWLINE = null;
	int V;
	int E;
	String b[];
     Bag<Integer>[] adj;
     public Graphs(int V)
     {
    	 this.V=V;
    	 adj=(Bag<Integer>[])new Bag[V];
    	 for(int v=0;v<V;v++)
    		 adj[v]=new Bag<Integer>();
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
public Graphs(BufferedReader in) throws IOException
{
this(Integer.parseInt(in.readLine()));
int E=Integer.parseInt(in.readLine());
String a=in.readLine();
StringTokenizer st=new StringTokenizer(a,",");
 b=new String[st.countTokens()];
int j=0;
while(st.hasMoreTokens())
{
	b[j++]=st.nextToken();
	//System.out.println(b[0]+","+b[1]);
}
for(int i=0;i<E;i++)
{
	String z=in.readLine();
	String r[]=z.split(" ");
	int v=Integer.parseInt(r[0]);
	int w=Integer.parseInt(r[1]);
	addEddge(v,w);
}
}
void addEddge(int v,int w)
{
	E++;
	adj[v].add(w);
	adj[w].add(v);
}
public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(V + " vertices, " + E + " edges ");
    for (int v = 0; v < V; v++) {
    	
        s.append(b[v] + ": ");
        //System.out.println(v);
        for (int w : adj[v]) {
        
       
         s.append(b[w] + " ");
         
        }
        s.append("\n");
    }
    return s.toString();
}
}
 class Matrix
 {
	 int a[][];
	 String[] b;
	 
	 public Matrix (BufferedReader in,int s1,int s2) throws IOException
	 {
	
	// int E=Integer.parseInt(in.readLine());
		 super();
			a = new int[s1][s2];
			for(int i = 0;i<s1;i++)
			{
				for(int j = 0;j<s2;j++)
				{
					a[i][j]=0;
				}
			}
	 String a=in.readLine();
	
	 StringTokenizer st=new StringTokenizer(a,",");
	  b=new String[st.countTokens()];
	 int j=0;
	 while(st.hasMoreTokens())
	 {
	 	b[j++]=st.nextToken();
	 	
	 }
	 for(int i=0;i<s1;i++)
	 {
	 	String z=in.readLine();
	 	String r[]=z.split(" ");
	 	int v=Integer.parseInt(r[0]);
	 	//System.out.println(r[0]+ " nknddfad"+r[1]);
	 	int w=Integer.parseInt(r[1]);
	 	insert(v,w);
	 }
	 }
	
	public void insert(int n,int m)
	{
		a[n][m]=1;
		a[m][n]=1;
	}
	public void display(int n,int m)
	{
		int count=0;
		for(int i=0;i<n;i++)
    	{
    		int j=0;
    		for(;j<m;j++)
    		{
    			if(a[i][j]==0)
    				count++;	
    		}
    	}
		if(count!=a.length)
    	{
    		int i=0; 
    	for(i=0;i<n-1;i++)
    	{
    		int j=0;
    		for(;j<n;j++)
    		{
    			System.out.print(a[i][j]+" ");
    		}
    		
    		System.out.println();
    	}
    	int k=0;
    	for(k=0;k<n-1;k++)
		{
			System.out.print(a[i][k]+" ");
		}
		System.out.print(a[i][k]);
    	}
    	else
    		System.out.println("No edges");
    	
    }
	}
	 
	 
 


public class Solution {

	public static void main(String[] args) throws IOException {
	
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 String s=br.readLine();
	 
		 switch(s)
	 {
	 case "List":
		
		 Graphs g=new Graphs(br);
         System.out.println(g.toString());
		
		 break;
	 case "Matrix":
		 int s1=Integer.parseInt(br.readLine());
		 
		 int s2=Integer.parseInt(br.readLine());
		
		 Matrix m1=new Matrix(br,s1,s2);
		 System.out.println(s1+" vertices, "+s2+" edges");
m1.display(s1, s2);
		 break; 
	 }
	}

}


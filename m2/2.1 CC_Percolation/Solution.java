import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import java.util.Iterator;

import java.util.NoSuchElementException;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      Graph g=new Graph(br);
      
      CC c=new CC(g);
	 c.display();
	}

}

class Graph {
	int V;
	int E;
	String b[];
     Bag<Integer>[] adj;
     CC cc;
     
     @SuppressWarnings("unchecked")
	public Graph(int V)
     {
    	 this.V=V;
    	 
    	 adj=(Bag<Integer>[])new Bag[V+1];
    	 for(int v=1;v<=V;v++)
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
public Graph(BufferedReader in) throws IOException
{
this(Integer.parseInt(in.readLine()));
String z=in.readLine();
if(z==null)
{
	 System.out.println("false");
	 System.exit(0);;
}
while(z!=null)
{
	if(z.equals(""))
	{
		
		return;
	}
	//System.out.println(z);
	String r[]=z.split(" ");
	int v=Integer.parseInt(r[0]);
	int w=Integer.parseInt(r[1]);
	addEddge(v,w);
	z=in.readLine();
}
}
void addEddge(int v,int w)
{
	//System.out.println(E);
	E++;
	adj[v].add(w);
	adj[w].add(v);
}
}
class CC {
boolean[] marked;
int[] id;
int[] size;
int count;
public CC(Graph g)
{
	marked= new boolean[g.V()+1];
	id=new int[g.V()+1];
	size=new int[g.V()+1];
	for(int v=1;v<=g.V();v++)
	{
		if(!marked[v])
		{
			//System.out.println(v);
			dfs(g,v);
			count++;
		//System.out.println(count);
		}
	}
}
void dfs(Graph g,int v)
{
	marked[v]=true;
	id[v]=count;
	//System.out.println(id[v]);
	for(int w:g.adj(v))
	{
		//System.out.println(w);
		if(!marked[w])
		{
			dfs(g,w);
		}
	}
}
public int id(int v) {
    validatevertex(v);
    return id[v];
}
public int count() {
    return count;
}
public int size(int v) {
    validatevertex(v);
    return size[id[v]];
}

boolean connected(int v,int w)
{
	//System.out.println(v+"cc"+w);
	validatevertex(v);
	validatevertex(w);
	return id[v]==id[w];
}
void validatevertex(int v)
{
	int V=marked.length;
	if(v<0||v>=V)
		throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
}
void display()
{
	//System.out.println(count);
	if(count==1)
	{
		System.out.println("true");
	}
	else
		System.out.println("false");
}
}
/*************************************************************************
 *  Compilation:  javac Bag.java
 *  Execution:    java Bag < input.txt
 *
 *  A generic bag or multiset, implemented using a linked list.
 *
 *************************************************************************/

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

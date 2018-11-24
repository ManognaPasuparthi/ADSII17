
import java.util.ArrayList;
import java.util.Scanner;

class Edge 
{
@Override
	public String toString() {
		return  " "+v + "-" + w + "  " + (float)weight +"0000"+"  ";
	}
public final int v; int w;
public final double weight;
 Edge(int v, int w, double weight)
{
this.v = v;
this.w = w;
this.weight = weight;
}
public int v()
{ return v; }
public int w()
{ return w; }
public double weight()
{ return  weight; }

}
class Graph
{
 private int V,count=0;;
 private ArrayList<Edge>[] adj;
 public Graph(int V)
 {
 this.V = V;
 adj = (ArrayList<Edge>[]) new ArrayList[V+1];
 for (int v = 0; v <=V; v++)
 adj[v] = new ArrayList<Edge>();
 }
 public void addEdge(int s,int d,double weight)
 {count++;
	  Edge e=new Edge(s,d,weight);
	  Edge e1=new Edge(s,d,weight);
 int v = e.v();
 int w=e.v();
 int x=e.w();
 adj[v].add(e);
 adj[x].add(e1);
 }
 public Iterable<Edge> adj(int v)
 { return adj[v]; }
 int V()
 {
	  return V;
 }
 public void display()
 {
	 System.out.println(V-1+" vertices "+count+" edges");
	 for(int i = 0;i<V-1;i++)
	 {System.out.print(i +" :");
		 for(int j=adj[i].size()-1;j>=0;j--)
		 {
			System.out.print(adj[i].get(j));
		 }
		 System.out.println();
		 
	 }
	 
 }
}

public class Solution {
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int n1=s.nextInt();
		int n2=s.nextInt();
		Graph g=new Graph(n1+1);
		for(int i = 0;i<n2;i++)
		{
			int n11=s.nextInt();
			int n12=s.nextInt();
			int n13=s.nextInt();
			g.addEdge(n11, n12, n13);
			
		}
		String st=s.nextLine();
		String str=s.nextLine();
		
		switch(str)
		{
		case "Graph":
			g.display();
		break;
		case "DirectedPaths":break;
		case "ViaPaths":break;
		}
	}

}

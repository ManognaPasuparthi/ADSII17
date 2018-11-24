
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import sun.misc.Queue;

class Edge 
{
@Override
	public String toString() {
		return  " "+v + "-" + w + "  " + (float)weight +"0000"+" ";
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
public int E() {
	// TODO Auto-generated method stub
	return 0;
}

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
	 {System.out.print(i +":");
		 for(int j=adj[i].size()-1;j>=0;j--)
		 {
			System.out.print(adj[i].get(j));
		 }
		 if(i!=V-2)
		 System.out.println();
		 
	 }
	 
 }
}
class Bellman
{
	   boolean marked[];
	    Edge[] edgeto;
		double distto[];
		double d;
		Bellman(Graph e,int s)
		{
			distto =new double[e.V()];
			edgeto =new Edge[e.V()];
			for(int i=0;i<e.V();i++)
			{
				distto[i]=Double.POSITIVE_INFINITY;
				
			}
			distto[s]=0.0;
			 
				   relax(e);
		}
		public void display(int m) {
			for(int i=0;i<distto.length;i++)
			{		
				if(i==m)
					if(distto[i]!=Double.POSITIVE_INFINITY)
					System.out.println(distto[i]);
					else
					{
						System.out.println("No Path Found.");
					}
				
				
			}
		}

		void relax(Graph G)
		 {
			 for (int i = 1; i <= G.V(); i++)
				 for (int v = 0; v < G.V(); v++)
				 for (Edge e : G.adj(v))
				 {
				 int w = e.w();
				 if (distto[w] > distto[v] + e.weight())
				 {
				 distto[w] = distto[v] + e.weight();
				 edgeto[w] = e;
				 }
				 }
			 
		 }
}
 /*class fw {
	
Edge edgeto[][];
double distto[][];
fw(Graph g,int m)
{
	edgeto =new Edge[g.V()][g.V()];
	distto =new double[g.V()][g.V()];
	boolean hasNegativeCycle;
	for(int i=0;i<g.V();i++)
	{
		for(int j=0;j<g.V();j++)
		{
			distto[i][j]=Double.POSITIVE_INFINITY;
		}
	}
	for(int v=0;v<g.V();v++)
	{
		for(Edge e:g.adj(v))
		{
			distto[e.v()][e.E()]=e.w();
			edgeto[e.v()][e.E()]=e;
			
		}
		if(distto[v][v]>=0.0)
		{
			distto[v][v]=0.0;
			edgeto[v][v]=null;
		}
	}
	 for (int i = 0; i < g.V(); i++) {
                for (int v = 0; v < m; v++) {
             if (edgeto[v][i] == null) continue;  
             for (int w = 0; w < g.V(); w++) {
                 if (distto[v][w] > distto[v][i] + distto[i][w]) {
                     distto[v][w] = distto[v][i] + distto[i][w];
                     edgeto[v][w] = edgeto[i][w];
                 }
             }
            
             if (distto[v][v] < 0.0) {
                 hasNegativeCycle = true;
                 return;
             }
         }
     }
}
void display(int s,int d)
{
	
			System.out.println(distto[s][d]);
	
}
}*/
public class Solution {
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		ArrayList<Integer> a=new ArrayList<Integer>();
		int n1=s.nextInt();
		int n2=s.nextInt();
		Graph g=new Graph(n1+1);
		for(int i = 0;i<n2;i++)
		{
			int n11=s.nextInt();
			int n12=s.nextInt();
			a.add(n11);
			a.add(n12);
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
		case "DirectedPaths":
			int c1=s.nextInt();
			Bellman dj=new Bellman(g,c1);
		int c2=s.nextInt();
		dj.display(c2);
		if(!a.contains(c1) || !a.contains(c2))
		{
			//System.out.println("No Path Found.");
		}
			break;
		case "ViaPaths":
			
			/*int c11=s.nextInt();
			int c12=s.nextInt();
			int c13=s.nextInt();
			fw f=new fw(g,c11);
			f.display(c12,c13);
			break;*/
		}
	}

}

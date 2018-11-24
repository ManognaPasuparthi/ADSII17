package m8;

import java.util.ArrayList;

import sun.misc.Queue;

public class Solution {

	public static void main(String[] args) {

		Graph g=new Graph(6);
		g.addEdge(0, 1, 4);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 2);
		g.addEdge(2, 3, 4);
		g.addEdge(3, 4, 2);
		g.addEdge(4, 5, 6);
		Bellman b=new Bellman(g,0);
		b.display();
	}

}
 class Edge 
{
 public final int v; int w;
 public final double weight;
 public Edge(int v, int w, double weight)
 {
 this.v = v;
 this.w = w;
 this.weight = weight;
 }
 public int from()
 { return v; }
 public int to()
 { return w; }
 public int weight()
 { return (int) weight; }

}
 class Graph
 {
  private int V;
  private ArrayList<Edge>[] adj;
  public Graph(int V)
  {
  this.V = V;
  adj = (ArrayList<Edge>[]) new ArrayList[V];
  for (int v = 0; v < V; v++)
  adj[v] = new ArrayList<Edge>();
  }
  public void addEdge(int s,int d,double weight)
  {
	  Edge e=new Edge(s,d,weight);
  int v = e.from();
  adj[v].add(e);
  }
  public Iterable<Edge> adj(int v)
  { return adj[v]; }
  int V()
  {
	  return V;
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
	/*	void check(Graph g,int s)
		{

			Queue<Integer> q = new Queue<Integer>();
			marked[s] = true;
			distto[s] = 0;
			q.enqueue(s);
			while (!q.isEmpty())
			{
			 int v = q.dequeue();
			 marked[v] = false;
			 for (Edge e : g.adj(v))
			 {
			 int w = e.target();
			 if (distto[w] > distto[v] + e.weight())
			 {
			 distto[w] = distto[v] + e.weight();
			 pred[w] = e;
			 if (!marked[w])
			 {
			 marked[w] = true;
			 q.enqueue(w);
			 }
			 }
			 }
			}
		}*/


	public void display() {
		for(int i=0;i<distto.length;i++)
		{		
			
				System.out.println(distto[i]);
			
		}
	}

	void relax(Graph G)
	 {
		 for (int i = 1; i <= G.V(); i++)
			 for (int v = 0; v < G.V(); v++)
			 for (Edge e : G.adj(v))
			 {
			 int w = e.to();
			 if (distto[w] > distto[v] + e.weight())
			 {
			 distto[w] = distto[v] + e.weight();
			 edgeto[w] = e;
			 }
			 }
		 
	 }
	 
 }
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prims{
double weight;
boolean[] marked;
private Queue<Edge> mst = new LinkedList<Edge>();
public Prims(graph g)
{
	
	PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
	for(Edge e:g.edges())
	{
		//System.out.println(e);
		pq.add((Edge)e);
	}
	marked =new boolean[g.V()];
	while(!pq.isEmpty()&&mst.size()<g.V()-1)
	{
	Edge e=pq.poll();
	int v=e.source;
	int w= e.des;
   if(marked[v]&&marked[w])
   {
	 
	   continue;
   }
   else
   {
	 
	   marked[w]=true;
      marked[v]=true;
	   mst.add(e);
	   	   
	}
	}
	
}
public Iterable<Edge> edges() 
{
	System.out.println( );
    return mst;
}
public static void main(String[] args) throws IOException
{
	graph g=new graph(6);
	g.addEdge(0, 1, 4);
	g.addEdge(0, 2, 3);
	g.addEdge(1, 2, 1);
	g.addEdge(1, 3, 2);
	g.addEdge(2, 3, 4);
	g.addEdge(3, 4, 2);
	g.addEdge(4, 5, 6);
	//g.V();
	Prims k=new Prims(g);
	for (Edge e : k.edges()) 
	{
        System.out.println(e.source+","+e.des+","+e.weight);
    }
}
}
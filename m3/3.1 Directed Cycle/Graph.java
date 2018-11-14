import java.io.BufferedReader;
import java.io.IOException;

public class Graph {
int V;
int E;
Bag<Integer>[] adj;
public Graph(int v)
{
	this.V=v;
	adj=(Bag<Integer>[])new Bag[v];
	for(int i=0;i<v;i++)
	{
		adj[i]=new Bag<Integer>();
	}
}
public Graph(BufferedReader in) throws NumberFormatException, IOException
{
	this(Integer.parseInt(in.readLine()));
	int E=Integer.parseInt(in.readLine());
	
	for(int v=0;v<E;v++)
	{
		String r=in.readLine();
		String[] z=r.split(" ");
		int k=Integer.parseInt(z[0]);
		int w=Integer.parseInt(z[1]);
		addEdge(k,w);
	}
}
private boolean duplicate(int v2,int w) {
	 for (int w1 : adj[v2]) {
	        if(w1==w)
	        {
	        	return true;
	        }
       }
	return false;
}
public void addEdge(int v,int w)
{
	if(!duplicate(v,w))
	{
	E++;
	adj[v].add(w);
	}
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
}

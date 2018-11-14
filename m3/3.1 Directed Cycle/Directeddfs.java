
public class Directeddfs {
boolean[] marked;

public Directeddfs(Graph g) {
	marked=new boolean[g.V()];
	for(int i=0;i<g.V();i++){
		if(!marked[i])
		{
			dfs(g,i);
			//System.out.println(i);
		}
	}
}
void dfs(Graph g,int v)
{
	marked[v]=true;
	for(int w:g.adj(v))
	{
		//System.out.println(w);
		if(!marked[w])
		{
			dfs(g,w);
			//System.out.println(marked[w]);
       }
		else
		{
			System.out.println("Cycle exists.");
		    System.exit(0);
		}
	}
	marked[v]=false;
	
}	
boolean Visited(int v)
{
	return marked[v];
}
void  display()
{
	System.out.println("Cycle doesn't exists.");
}
}

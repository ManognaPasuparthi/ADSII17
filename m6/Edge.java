import java.util.ArrayList;
import java.util.Iterator;

public class Edge implements Comparable<Edge>{
int source;
int des;
int weight;

public Edge(int source, int des,int we) {
	this.source = source;
	this.des = des;
	this.weight=we;
}
@Override
public int compareTo(Edge arg0) {
  if(arg0.weight==this.weight)
	return 0;
  else if(arg0.weight>this.weight)
	  return -1;
  else
	  return 1;
}

}
class graph
{
	ArrayList<Edge> a=new ArrayList<Edge>();
	int v;
	public graph(int v)
	{
		this.v=v;
	}
	void addEdge(int s,int d,int w)
	{
		System.out.println(s+","+d+","+w);
		
		
		a.add(new Edge(s,d,w));
	}
	Iterable<Edge> a(int v)
	{
		return a;
	}
    int V()
    {
    	//System.out.println(v);
    	return v;
    }
    public Iterable<Edge> edges() {
    	ArrayList<Edge> list = new ArrayList<Edge>();
        
           Iterator i=a.iterator();
        while(i.hasNext())
        {
        	//System.out.println(((Edge)i.next()).weight);
        	list.add((Edge)i.next());
        }
        return list;
    } 
}
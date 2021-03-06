package MODULE7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

import javafx.util.Pair;

class Edge
{
	int source;
	int destination;
	int  weight;
public Edge(int source, int destination, int weight) {
		super();
		this.source = source;
		this.destination = destination;
		this.weight = weight;
}
}
class Graph
{
	int n;
	LinkedList<Edge> adj[];
Graph(int n)
{this.n=n;
	 adj= new LinkedList[n];
	for(int i=0;i<n;i++)
	{
	 adj[i]=new LinkedList<Edge>();
	}
}
	
public void addEdge(int source,int destination,int weight)
{
	
Edge edge=new Edge(source, destination, weight);
adj[source].addFirst(edge);
	//adj[v].add(w);
	//adj[w].add(v);
}
public void get_min_distance(int sourceVertex,int destinationVertex)
{
	 boolean[] SPT = new boolean[n];
	 int [] distance = new int[n];
	 for (int i = 0; i <n ; i++) 
	 {
         distance[i] = Integer.MAX_VALUE;
     }
	 PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(n, new Comparator<Pair<Integer, Integer>>() {
         public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
             //sort using distance values
        	 
             int key1 = p1.getKey();
             int key2 = p2.getKey();
             return key1-key2;
         }
	 });
     distance[0] = 0;
     Pair<Integer, Integer> p0 = new Pair<>(distance[0],0);
     
     pq.offer(p0);

     
     while(!pq.isEmpty()){
        
         Pair<Integer, Integer> extractedPair = pq.poll();

         
         int extractedVertex = extractedPair.getValue();
         if(SPT[extractedVertex]==false) {
             SPT[extractedVertex] = true;
             LinkedList<Edge> list = adj[extractedVertex];
             for (int i = 0; i < list.size(); i++) {
                 Edge edge = list.get(i);
                 int destination = edge.destination;
                 if (SPT[destination] == false) {
                     
                     int newKey =  distance[extractedVertex] + edge.weight ;
                     int oldKey = distance[destination];
                     if(oldKey>newKey){
                         Pair<Integer, Integer> p = new Pair<>(newKey, destination);
                         pq.offer(p);
                         distance[destination] = newKey;
                     }
                 }
             }
         }
     }

     printDijkstra(distance, sourceVertex,destinationVertex);
 }

 public void printDijkstra(int[] distance, int sourceVertex,int destinationVertex){
     System.out.println("Dijkstra Algorithm: (Adjacency List + Priority Queue)");
     for (int i = 0; i <n ; i++) {
    	 if(i==destinationVertex)
         System.out.println("Source Vertex: " + sourceVertex + " to vertex " +   + i +
                 " distance: " + distance[i]);
     }
}
}
public class Solution {
	 public static void main(String[] args) {
		 Scanner s=new Scanner(System.in);
	     int vertices = s.nextInt();
	     Graph graph = new Graph(vertices);
	     int edge=s.nextInt();
	     Vector<String> v1=new Vector<String>();
	     for(int i = 0;i<vertices;i++)
	     {
	    	 v1.add(s.next());
	     }
	     for(int i=0;i<v1.size();i++)
	     System.out.println(v1.get(i)+"   "+v1.indexOf(v1.get(i)));
	     for(int i = 0;i<edge;i++)
	     {
	    	
	    	 int n1=v1.indexOf(s.next());
	    	 int n2=v1.indexOf(s.next());	
	    	 int w=s.nextInt();
	    	 graph.addEdge(n1,n2, w);
	     }
	     int l=s.nextInt();
	     for(int i = 0;i<l;i++)
	     {
	    	
	    	 int n1=v1.indexOf(s.next());
	    	 int n2=v1.indexOf(s.next());	
	     graph.get_min_distance(n1,n2);
	     }
	   
	     }
}
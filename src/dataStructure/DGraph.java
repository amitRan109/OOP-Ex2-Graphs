package dataStructure;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;


public class DGraph implements graph,Serializable{
	// **params**
	HashMap <Integer,node_data> gmap; 
	int counter;
	
	public DGraph () {
		gmap= new HashMap <> ();
	}
	//**functions**
	public String toString () {
		String ans="";
		for (node_data node : gmap.values()) {
			ans+=((DNode)node).toString()+": ";
			for (edge_data edge : ((DNode)node).getE()) {
			ans+=((DEdge)edge).toString();
		}
		ans+=",";
		}
		return ans;
	}
	
	

	@Override
	public node_data getNode(int key) {
		return gmap.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		return ((DNode)gmap.get(src)).getEdge(dest);
	}

	@Override
	public void addNode(node_data n) {
		counter++;
		gmap.put(n.getKey(),n);
	}

	@Override
	public void connect(int src, int dest, double w) {
		counter++;
		DEdge edge= new DEdge (src,dest,w);
		((DNode)gmap.get(src)).add(dest, edge);
	}

	@Override
	public Collection<node_data> getV() {
		return gmap.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		return ((DNode)gmap.get(node_id)).getE();
	}

	@Override
	public node_data removeNode(int key) {
		counter++;
		return gmap.remove(key);
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		counter++;
		return ((DNode)gmap.get(src)).removeEdge(dest);
	}

	@Override
	public int nodeSize() {
		return gmap.size();
	}

	@Override
	public int edgeSize() {
		int counter=0;
		for (node_data node : gmap.values()) {
			counter+=((DNode)node).getSize();
		}
		return counter;
	}

	@Override
	public int getMC() {
		return counter;
	}

}
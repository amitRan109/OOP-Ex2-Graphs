package algorithms;

import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

//import dataStructure.DGraph;
import dataStructure.DNode;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms{
	//**params**
	private graph g;


	@Override
	public void init(graph g) {
		this.g=g;
	}

	@Override
	public void init(String file_name) {

	}

	@Override
	public void save(String file_name) {

	}

	@Override
	public boolean isConnected() {
		Queue<DNode> q=new ArrayBlockingQueue<DNode>(g.getMC());
		for (node_data nodes : g.getV()) {
			nodes.setTag(0);

		}
		for (node_data node : g.getV() ) {
			DNode n=(DNode) node;
			if (n.getE()== null) return false;
			q.add(n);
			n.setTag(1);
			while (!q.isEmpty()) {
				for (edge_data edge : q.peek().getE() ) {
					DNode dest=(DNode) g.getNode(edge.getDest());
					if(dest.getTag()==0) {
						dest.setTag(1);
						q.add(dest);}
				}
				q.remove();
			}
			for (node_data nodes : g.getV()) {
				if (nodes.getTag()==0) return false;
				else nodes.setTag(0);
			}

		}
		for (node_data nodes : g.getV()) {
			nodes.setTag(0);

		}
		return true;

	}
	public int getMin() {
		DNode min=new DNode(-1);
		int key=0;
		min.setWeight(Double.MAX_VALUE);
		for (node_data nodes : g.getV()) {
			if(nodes.getWeight()<min.getWeight()&& nodes.getTag()==0) {
				key=nodes.getKey();
				min=(DNode)nodes;
			}
		}
		return key;
	}
	@Override
	public double shortestPathDist(int src, int dest) {
		for (node_data nodes : g.getV()) {
			nodes.setTag(0);
			nodes.setWeight(Double.MAX_VALUE);
		}
		DNode src1=(DNode)((g.getNode(src)));
		src1.setWeight(0);
		int counter=g.getMC();
		while(counter>0) {
			DNode min=(DNode)g.getNode(getMin());
			min.setTag(1);
			for (edge_data edge: min.getE()) {
				DNode neighbor= (DNode) g.getNode(edge.getDest()); 
					if(min.getWeight()+edge.getWeight()<neighbor.getWeight()) {
						neighbor.setWeight(min.getWeight()+edge.getWeight());
						neighbor.setMark(min.getKey());
					
				}
				
			}
			counter--;
		}
		return g.getNode(dest).getWeight();
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		//DNode temp=(DNode)g.getNode(dest);
		//List<DNode> ans;
		//Stack<DNode> s=new Stack<DNode>();
		List<node_data> l = null;
		return l;
		
		
		
		
		
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		return null;
	}

	@Override
	public graph copy() {
		return null;
	}

}
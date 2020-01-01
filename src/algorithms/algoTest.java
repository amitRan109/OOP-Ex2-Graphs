package algorithms;

import java.util.LinkedList;

import java.util.List;

import dataStructure.DEdge;
import dataStructure.DGraph;
import dataStructure.DNode;
import dataStructure.node_data;

public class algoTest {

	public static void main(String[] args) {

		DGraph g = new DGraph ();
		DNode n1 = new DNode (1);	
		DNode n2 = new DNode (2);
		DNode n3 = new DNode (3);
		DNode n4 = new DNode (4);
		DNode n5 = new DNode (5);
		DNode n6 = new DNode (6);
		DNode n7 = new DNode (7);
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		g.addNode(n6);
		g.addNode(n7);
		g.connect(n1.getKey(), n3.getKey(), 3);
		g.connect (n1.getKey(),n5.getKey(),7);
		g.connect (n1.getKey(),n2.getKey(),4);
		g.connect (n2.getKey(),n4.getKey(),5);
		g.connect (n2.getKey(),n3.getKey(),6);
		g.connect (n3.getKey(),n5.getKey(),8);
		g.connect (n4.getKey(),n6.getKey(),2);
		g.connect (n4.getKey(),n3.getKey(),11);
		g.connect (n5.getKey(),n4.getKey(),10);
		g.connect (n5.getKey(),n7.getKey(),5);
		g.connect (n6.getKey(),n7.getKey(),3);
		System.out.println("g: "+g.toString());
		Graph_Algo ga=new Graph_Algo();
		ga.init(g);
		ga.save("hi");
		Graph_Algo gt=new Graph_Algo();
		gt.init("hi");
		
		//System.out.println(ga.isConnected());
		List<node_data> s=new LinkedList <node_data>();
		//s=ga.shortestPath(n1.getKey(), n6.getKey());
		//System.out.println(ga.shortestPathDist(n4.getKey(), n6.getKey()));
		//System.out.println(s);
		List<node_data> check=new LinkedList <node_data>();
		List<Integer> targets=new LinkedList <Integer>();
		targets.add(1);
		targets.add(4);
		targets.add(7);
		targets.add(5);
		check=ga.TSP(targets);
		System.out.println(check);
	}

}
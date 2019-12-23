package algorithms;

import dataStructure.DEdge;
import dataStructure.DGraph;
import dataStructure.DNode;

public class algoTest {

	public static void main(String[] args) {

		DGraph g = new DGraph ();
		//System.out.println("g1: "+g.toString());
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
		//System.out.println("g2: "+g.toString());
		DEdge e = new DEdge (n1.getKey(),n3.getKey(),3);
		DEdge e1 = new DEdge (n1.getKey(),n5.getKey(),7);
		DEdge e2 = new DEdge (n1.getKey(),n2.getKey(),4);
		DEdge e3 = new DEdge (n2.getKey(),n4.getKey(),5);
		DEdge e4 = new DEdge (n2.getKey(),n3.getKey(),6);
		DEdge e5 = new DEdge (n3.getKey(),n5.getKey(),8);
		DEdge e6 = new DEdge (n4.getKey(),n6.getKey(),2);
		DEdge e7 = new DEdge (n4.getKey(),n3.getKey(),11);
		DEdge e8 = new DEdge (n5.getKey(),n4.getKey(),10);
		DEdge e9 = new DEdge (n5.getKey(),n7.getKey(),5);
		DEdge e10 = new DEdge (n6.getKey(),n7.getKey(),3);
		n1.add(e.getDest(), e);
		n1.add(e1.getDest(), e1);
		n1.add(e2.getDest(), e2);
		n2.add(e3.getDest(), e3);
		n2.add(e4.getDest(), e4);
		n3.add(e5.getDest(), e5);
		n4.add(e6.getDest(), e6);
		n4.add(e7.getDest(), e7);
		n5.add(e8.getDest(), e8);
		n5.add(e9.getDest(), e9);
		n6.add(e10.getDest(), e10);
		System.out.println("g3: "+g.toString());
		Graph_Algo ga=new Graph_Algo();
		ga.init(g);
		//System.out.println(ga.isConnected());
		//System.out.println(ga.toString());
		System.out.println(ga.shortestPathDist(n1.getKey(), n4.getKey()));
	}

}
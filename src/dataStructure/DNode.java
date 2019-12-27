package dataStructure;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

import utils.Point3D;

public class DNode implements node_data,Serializable {
	//**params**
	private int key; //name
	private String info; //md
	private Point3D location;
	private double weight; //kivun
	private int tag; //if used
	HashMap <Integer,edge_data> map;
	int mark ;
	
	//**constructor**
	public DNode (int key, String info, Point3D location, double weight, int tag,int mark) {
		this.key=key; 
		this.info=info; 
		this.location=location;
		this.weight=weight; 
		this.tag=tag; 
		map= new HashMap <>();
		this.mark=mark;
	}
	
	public DNode (int k) {
		this.key=k;
		this.info=null;
		this.location=null;
		this.weight=Double.MAX_VALUE;
		this.tag=0;
		map= new HashMap <>();
		this.mark=-1;
	}
	
	//**map functions**
	public void add(int dest, edge_data e) {
		map.put(dest, e);
	}
	
	public edge_data getEdge(int dest) {
		return map.get(dest);
	}
	
	public edge_data removeEdge(int dest) {
		return map.remove(dest);
	}
	
	public int getSize () {
		return map.size();
	}
	
	public Collection<edge_data> getE(){
		return map.values();
	}
	
	public String toString () {
	return ""+this.key;
		
	}
	
	//***getters & setters
	@Override
	public int getKey() {
		return this.key;
	}

	@Override
	public Point3D getLocation() {
		return this.location;
	}

	@Override
	public void setLocation(Point3D p) {
		this.location=p;
		
	}

	@Override
	public double getWeight() {
		return this.weight;
	}

	@Override
	public void setWeight(double w) {
		this.weight=w;
	}

	@Override
	public String getInfo() {
		return this.info;
	}

	@Override
	public void setInfo(String s) {
		this.info=s;
	}

	@Override
	public int getTag() {
		return this.tag;
	}

	@Override
	public void setTag(int t) {
		this.tag=t;
		
	}
	
	public void setMark(int m) {
		this.mark=m;
		
	}
	
	public int getMark() {
		return this.mark;
		
	}

}
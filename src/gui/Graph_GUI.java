package gui;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import algorithms.Graph_Algo;
import dataStructure.DEdge;
import dataStructure.DGraph;
import dataStructure.DNode;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;

public class Graph_GUI extends JFrame implements ActionListener,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DGraph gr;
	private Graph_Algo ga;

	public Graph_GUI() {
		initGUI();
	}

	public void setGraph(DGraph g) {
		this.gr = g;
		this.ga = new Graph_Algo();
		this.ga.init(g);
		// repaint();
	}

	private void initGUI() {
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMenu();
	}

	public void setMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("file");
		JMenu algo = new JMenu("Algorithems");
		JMenu path = new JMenu("shortest path");
		JMenuItem i1 = new JMenuItem("show Graph");
		i1.addActionListener(this);
		JMenuItem i2 = new JMenuItem("save Graph");
		i2.addActionListener(this);
		JMenuItem i3 = new JMenuItem("is connected");
		i3.addActionListener(this);
		JMenuItem i4 = new JMenuItem("number");
		i4.addActionListener(this);
		JMenuItem i5 = new JMenuItem("visual");
		i5.addActionListener(this);
		JMenuItem i6 = new JMenuItem("TSP");
		i6.addActionListener(this);
		file.add(i1);
		file.add(i2);
		file.add(algo);
		algo.add(path);
		algo.add(i3);
		algo.add(i6);
		path.add(i4);
		path.add(i5);
		file.add(file);
		menuBar.add(file);
		this.setJMenuBar(menuBar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		switch (str) {
		case "is connected":
			final JFrame isConnected = new JFrame();
			isConnected.setSize(200, 200);
			JLabel label0 = new JLabel();
			label0.setFont(new Font("Courier", Font.PLAIN, 20));
			label0.setText(Boolean.toString(ga.isConnected()));
			isConnected.add(label0);
			isConnected.setVisible(true);
			//isConnected.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
			break;

		case "number":
			JFrame number=new JFrame(); 
			//submit button
			JButton buttonn=new JButton("ok");    
			buttonn.setBounds(100,110,140, 40);    
			//enter name label
			JLabel labeln = new JLabel();		
			labeln.setText("enter source and destination :");
			labeln.setBounds(10, 10, 500, 100);
			//empty label which will show event after button clicked
			JLabel labeln1 = new JLabel();
			labeln1.setBounds(10, 110, 200, 100);
			//textfield to enter name
			JTextField textfield= new JTextField();
			textfield.setBounds(110, 70, 130, 30);
			//add to frame
			number.add(labeln1);
			number.add(textfield);
			number.add(labeln);
			number.add(buttonn);    
			number.setSize(300,300);    
			number.setLayout(null);    
			number.setVisible(true);    
			//number.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

			//action listener
			buttonn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					String name = textfield.getText();
					int i=name.indexOf(",");
					String src=name.substring(0, i);
					String dest=name.substring(i+1, name.length());
					//System.out.println(Integer.parseInt(src)+Integer.parseInt(dest));
					labeln1.setText("the shortest path is: "+Double.toString
							(ga.shortestPathDist(Integer.parseInt(src),Integer.parseInt(dest))));				       				
				}          
			});

			break;

		case "visual":
			JFrame visual=new JFrame(); 
			//submit button
			JButton buttonv=new JButton("ok");    
			buttonv.setBounds(100,110,140, 40);    
			//enter name label
			JLabel labelv = new JLabel();		
			labelv.setText("enter source and destination :");
			labelv.setBounds(10, 10, 500, 100);
			//empty label which will show event after button clicked
			JLabel labelv1 = new JLabel();
			labelv1.setBounds(10, 110, 200, 100);
			//textfield to enter name
			JTextField textfieldv= new JTextField();
			textfieldv.setBounds(110, 70, 130, 30);
			//add to frame
			visual.add(labelv1);
			visual.add(textfieldv);
			visual.add(labelv);
			visual.add(buttonv);    
			visual.setSize(300,300);    
			visual.setLayout(null);    
			visual.setVisible(true);    

			//action listener
			buttonv.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					String text = textfieldv.getText();
					int i=text.indexOf(",");
					String src=text.substring(0, i);
					String dest=text.substring(i+1, text.length());
					//System.out.println(Integer.parseInt(src)+Integer.parseInt(dest));
					List<node_data> l= new LinkedList <node_data> ();
					//l=ga.shortestPath(d.getKey(),g.getKey());					
					l=ga.shortestPath(Integer.parseInt(src),Integer.parseInt(dest));				  
					labelv1.setText("the shortest path is: "+l.toString());				       				
				}          
			});

			break;

		case "TSP":
			JFrame tsp=new JFrame(); 
			
			//submit button
			JButton buttont=new JButton("ok");    
			buttont.setBounds(100,110,140, 40);   
			
			//enter name label
			JLabel labelt = new JLabel();		
			labelt.setText("enter a list of node you want to pass threw them :");
			labelt.setBounds(10, 10, 500, 100);
			
			//empty label which will show event after button clicked
			JLabel labelt1 = new JLabel();
			labelt1.setBounds(10, 110, 200, 100);
			
			//textfield to enter name
			JTextField textfieldt= new JTextField();
			textfieldt.setBounds(110, 70, 130, 30);
			
			//add to frame
			tsp.add(labelt1);
			tsp.add(textfieldt);
			tsp.add(labelt);
			tsp.add(buttont);    
			tsp.setSize(300,300);    
			tsp.setLayout(null);    
			tsp.setVisible(true);    

			//action listener
			buttont.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					String text = textfieldt.getText();
					String [] target= text.split(",");
					
					List<Integer> targets= new LinkedList <Integer> ();
					List<node_data> ans= new LinkedList <node_data> ();
					int i=0;
					while (i<target.length) {
						targets.add(Integer.parseInt(target[i]));
						i++;
					}
					ans=ga.TSP(targets);				  
					labelt1.setText("the TSP is: "+ans.toString());				       				
				}          
			});

			break;
		case "save Graph":
			ga.save("your Graph");	
			JFrame save=new JFrame(); 
			JLabel labels = new JLabel();		
			labels.setText("your file was saved by name:"+"'your Graph'" );
			labels.setBounds(10, 10, 500,100);
			save.add(labels);
			save.setSize(300, 300);
			save.setLayout(null);
			save.setVisible(true);
			
			break;
		case "show Graph":
			showGraph = true;
			repaint();
			break;

		}
	}
	private boolean showGraph = false;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(!showGraph)
			return;
		
		for (node_data n : gr.getV()) {
			n.setTag(0);
		}
		for (node_data n : gr.getV()) {
			//first node src=n
			if (n.getTag() == 0) {
				g.setColor(Color.BLUE);
				Point3D loc = n.getLocation();// src location
				g.fillOval(loc.ix(), loc.iy(), 10, 10);//draw src
				n.setTag(1);
				g.setColor(Color.black);
				g.setFont(new Font("Courier", Font.PLAIN, 20));
				for (edge_data dest : gr.getE(n.getKey())) {
					//src edges
					if (dest.getTag() == 0) {
						g.setColor(Color.BLUE);
						Point3D loc1 = ((DNode) gr.getNode(dest.getDest())).getLocation();//dest location
						g.fillOval(loc1.ix(), loc1.iy(), 20, 20);//draw dest
						dest.setTag(1);
						g.setColor(Color.black);
						g.drawString(Integer.toString(((DNode) gr.getNode(dest.getDest())).getKey()), loc1.ix(),
								loc1.iy());//draw dest key
						g.setColor(Color.PINK);
						Graphics2D g2 = (Graphics2D) g;
						g2.setStroke(new BasicStroke(5));
						g.drawLine(loc.ix(), loc.iy(), loc1.ix(), loc1.iy());//draw edge
						g.setColor(Color.black);
						Graphics2D g8 = (Graphics2D) g;
						g8.setStroke(new BasicStroke(10));
						g.setColor(Color.RED);
						g.fillOval((int)((loc.ix()*0.7)+(0.3*loc1.ix()))+2, 1+(int)((loc.iy()*0.7)+(0.3*loc1.iy())), 8, 8);//draw errow
						g.setColor(Color.black);
						g.drawString((Double.toString(dest.getWeight())), (int)((loc.x()+loc1.x())/2),(int)((loc.y()+loc1.y())/2));//draw edge weigth
					}
				}
				g.drawString(Integer.toString(n.getKey()), loc.ix(), loc.iy());//draw src key

			}
		}
	}


	public static void main(String[] args) {
		Graph_GUI window = new Graph_GUI();
		DGraph g = new DGraph();
		DNode n1 = new DNode(1);
		DNode n2 = new DNode(2);
		DNode n3 = new DNode(3);
		n1.setLocation(new Point3D(200, 300));
		n2.setLocation(new Point3D(300, 200));
		n3.setLocation(new Point3D(100, 100));
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		Graph_Algo ga=new Graph_Algo();
		ga.init(g);
		ga.save("hi");
		Graph_Algo gt=new Graph_Algo();
		gt.init("hi");
		Graph_GUI wi = new Graph_GUI();
		wi.setGraph((DGraph) gt.g);
		wi.setVisible(true);
		DEdge e = new DEdge(n1.getKey(), n2.getKey(), 3);
		DEdge e1 = new DEdge(n2.getKey(), n3.getKey(), 7);
		n1.add(e.getDest(), e);
		n2.add(e1.getDest(), e1);
//		window.setGraph(g);
//		window.setVisible(true);
		
		
		
	}
}
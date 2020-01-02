package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.DNode;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;

public class Graph_GUI extends JFrame implements ActionListener, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//delete toString


	//**params**
	private DGraph gr;
	private Graph_Algo ga;
	
	//**constructor**
	public Graph_GUI() {
		initGUI();
	}
	public Graph_GUI(graph g) {
		this.gr = (DGraph)g;
		this.ga = new Graph_Algo();
		this.ga.init(g);
		initGUI();
	}
	//**functions**
	
	public void setGraph_Algo(Graph_Algo ga) {
		this.ga = new Graph_Algo();
		this.ga = ga;
		this.gr = (DGraph) ga.copy();
	}

	private void initGUI() {
		this.setSize(1000, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMenu();
	}

	public void setMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("file");
		JMenu algo = new JMenu("Algorithems");
		JMenu path = new JMenu("shortest path");
		JMenuItem upload = new JMenuItem("upload file");
		upload.addActionListener(this);
		JMenuItem show = new JMenuItem("show Graph");
		show.addActionListener(this);
		JMenuItem save = new JMenuItem("save Graph");
		save.addActionListener(this);
		JMenuItem connect = new JMenuItem("is connected");
		connect.addActionListener(this);
		JMenuItem number = new JMenuItem("number");
		number.addActionListener(this);
		JMenuItem visual = new JMenuItem("visual");
		visual.addActionListener(this);
		JMenuItem TSP = new JMenuItem("TSP");
		TSP.addActionListener(this);
		file.add(show);
		file.add(save);
		file.add(upload);
		file.add(algo);
		algo.add(path);
		algo.add(connect);
		algo.add(TSP);
		path.add(number);
		path.add(visual);
		menuBar.add(file);
		this.setJMenuBar(menuBar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		switch (str) {
		case "is connected":
			final JFrame isConnected = new JFrame();
			isConnected.setSize(300, 200);
			JLabel label0 = new JLabel();
			label0.setFont(new Font("Courier", Font.PLAIN, 20));
			if (ga.isConnected())
			label0.setText("The graph is connected");
			else label0.setText("The graph is'nt connected");

			isConnected.add(label0);
			isConnected.setVisible(true);
			break;

		case "number":
			JFrame number=new JFrame(); 

			//submit button
			JButton buttonn=new JButton("Ok");    
			buttonn.setBounds(100,110,140, 40);    
			//enter name label
			JLabel labeln = new JLabel();		
			labeln.setText("Enter source and destination : (example: 1,2)");
			labeln.setBounds(10, 10, 500, 100);

			//empty label which will show event after button clicked
			JLabel labeln1 = new JLabel();
			labeln1.setBounds(10, 110, 200, 100);

			//textfield to enter name
			JTextField textfield= new JTextField();
			textfield.setBounds(110, 80, 130, 30);

			//add to frame
			number.add(labeln1);
			number.add(textfield);
			number.add(labeln);
			number.add(buttonn);    
			number.setSize(300,300);    
			number.setLayout(null);    
			number.setVisible(true);     

			//action listener
			buttonn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					String text = textfield.getText();
					int i=text.indexOf(",");
					String src=text.substring(0, i);
					String dest=text.substring(i+1, text.length());
					System.out.println("src "+src+" sdt "+dest);
					double ans=ga.shortestPathDist(Integer.parseInt(src),Integer.parseInt(dest));
					System.out.println(ans);
					if (ans>0) {
						labeln1.setText("The shortest path is: "+Double.toString(ans));
					}
					else System.out.println("There is a problem. please try again");
				}          
			});

			break;

		case "visual":
			JFrame visual=new JFrame(); 

			//submit button
			JButton buttonv=new JButton("Ok");    
			buttonv.setBounds(100,110,140, 40);

			//enter name label
			JLabel labelv = new JLabel();		
			labelv.setText("Enter source and destination : (example:1,2)");
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
					if (text != null) {
						int i=text.indexOf(",");
						String src=text.substring(0, i);
						String dest=text.substring(i+1, text.length());
						List<node_data> l= new LinkedList <node_data> ();
						l=ga.shortestPath(Integer.parseInt(src),Integer.parseInt(dest));				  
						labelv1.setText("The shortest path is: "+l.toString());				       				
					}
					else labelv1.setText("There is a problem. please try again");	
				}          
			});

			break;

		case "TSP":
			JFrame tsp=new JFrame(); 

			//submit button
			JButton buttont=new JButton("Ok");    
			buttont.setBounds(100,110,140, 40);   

			//enter name label
			JLabel labelt = new JLabel();		
			labelt.setText("Enter a list of nodes you want to pass threw them : (example: 1,2)");
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
			tsp.setSize(500,300);    
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
					if (ans != null) {
						String ans_s="";
						for (node_data n: ans) {
							ans_s+=n.getKey()+"-->";
						}
						labelt1.setText("The TSP is: "+ans_s);	
					}
					else labelt1.setText("There is no way between these nodes");	
				}          
			});

			break;

		case "save Graph":

			ga.save("your graph");
			JFrame save=new JFrame(); 
			JLabel labels = new JLabel();		
			labels.setText("Your file was saves by the name: your graph" );
			labels.setBounds(10, 10, 500, 100);
			save.add(labels);
			save.setSize(300,300);    
			save.setVisible(true);    
			break;

		case "show Graph":
			repaint();
			break;

		case "upload file":
			JFrame upload=new JFrame(); 

			//submit button
			JButton buttonu=new JButton("Ok");    
			buttonu.setBounds(100,110,140, 40); 
			
			//enter name label
			JLabel labelu = new JLabel();		
			labelu.setText("Enter the name of the file");
			labelu.setBounds(10, 10, 500, 100);

			//empty labels which will show event after button clicked
			JLabel labelu1 = new JLabel();
			labelu1.setBounds(10, 110, 200, 100);
			JLabel labelu2 = new JLabel();
			labelu2.setBounds(10, 110, 200, 100);

			//textfield to enter name
			JTextField textfieldu= new JTextField();
			textfieldu.setBounds(110, 80, 130, 30);

			upload.add(labelu);
			upload.add(labelu2);
			upload.add(labelu1);
			upload.add(textfieldu);
			upload.add(buttonu);    
			upload.setSize(300,300);    
			upload.setLayout(null);    
			upload.setVisible(true);     

			//action listener
			buttonu.addActionListener(new ActionListener() {


				@Override
				public void actionPerformed(ActionEvent arg0) {
					String file_name = textfieldu.getText();
					System.out.println(file_name);
					Graph_Algo ga1 = new Graph_Algo ();
					ga1.init(file_name);
					setGraph_Algo(ga1);
					labelu1.setText("the graph uploaded succecfully");	

				}          
			});

			break;
		}

	}


	@Override
	public void paint(Graphics g) {
		super.paint(g);

		for (node_data n : gr.getV()) {
			n.setTag(0);
		}

		for (node_data n : gr.getV()) {

			//location of n
			Point3D loc = n.getLocation(); 
			for (edge_data dest : gr.getE(n.getKey())) {

				//location of neighbor
				Point3D loc1 = ((DNode) gr.getNode(dest.getDest())).getLocation(); 

				//print edge between n and dest
				g.setColor(Color.PINK);
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(2));
				g.drawLine(loc.ix(), loc.iy(), loc1.ix(), loc1.iy()); 

				//edge weight
				g.setColor(Color.black);
				Graphics2D g3 = (Graphics2D) g;
				g3.setStroke(new BasicStroke(2));
				g.drawString((Double.toString(dest.getWeight())), (int)((loc.x()+loc1.x())/2),(int)((loc.y()+loc1.y())/2)); 

				//mark src	
				g.setColor(Color.RED);
				g.fillOval((int)((loc.ix()*0.7)+(0.3*loc1.ix())), 1+(int)((loc.iy()*0.7)+(0.3*loc1.iy())), 8, 8); 

				//print neighbor
				if (gr.getNode(dest.getDest()).getTag() == 0) {
					//neighbor point
					g.setColor(Color.BLUE);
					g.fillOval(loc1.ix(), loc1.iy(), 8, 8); 

					g.setColor(Color.black);
					g.setFont(new Font("Courier", Font.PLAIN, 20));
					//neighber key
					g.setColor(Color.black);
					g.drawString(Integer.toString(((DNode) gr.getNode(dest.getDest())).getKey()), loc1.ix(),loc1.iy());


					//mark the neighbor
					gr.getNode(dest.getDest()).setTag(1); 
				}
			}
			if (n.getTag() == 0) {
				g.setColor(Color.BLUE);
				//n point
				g.fillOval(loc.ix(), loc.iy(), 10, 10); 
				
				g.setColor(Color.black);
				g.setFont(new Font("Courier", Font.PLAIN, 20));
				// n key
				g.drawString(Integer.toString(n.getKey()), loc.ix(), loc.iy()); 
			}

			//mark n
			n.setTag(1);
		}
	}
}
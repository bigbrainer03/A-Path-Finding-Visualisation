package pathfinder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Panels extends JPanel{
	// Window settings
	final int maxCol=10;
	final int maxRow=10;
	final int nodeSize=70;
	final int screenWidth=nodeSize * maxCol;
	final int screenHeight=nodeSize * maxRow;
	
	//Node
	Node[][] node=new Node[maxCol][maxRow];
	Node startNode, endNode, currentNode;
	public Panels() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.BLACK);
		this.setLayout(new GridLayout(maxRow,maxCol));
		this.addKeyListener(new KeyHandler(this));
		this.setFocusable(true);
		
		//Placing the Nodes on the Panel
		int col=0;
		int row=0;
		
		while(col < maxCol && row < maxRow) {
			node[col][row]=new Node(col,row);
			this.add(node[col][row]);
			col++;
			if(col==maxCol) {
				col=0;
				row++;
			}
		}	
	}
		public void setStartNode(int col, int row) {
			node[col][row].setasStart();
			startNode=node[col][row];
			currentNode=startNode;
	}
		public void setEndNode(int col, int row) {
			node[col][row].setasEnd();
			endNode=node[col][row];
		}
}

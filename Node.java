package pathfinder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class Node extends JButton implements ActionListener{
	
	Node parent;
	int col;
	int row;
	int gCost;
	int hCost;
	int fCost;
	boolean start;
	boolean end;
	boolean solid;
	boolean open;
	boolean checked;
	
	public Node(int col, int row) {
		this.col=col;
		this.row=row;
		
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		addActionListener(this);
			
	}
	
	public void setasStart() {
		start=true;
		setBackground(Color.blue);
		setForeground(Color.white);
		setText("Start");
		addActionListener(this);
	}
	public void setasEnd() {
		end=true;
		setBackground(Color.red);
		setForeground(Color.white);
		setText("End");	
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setBackground(Color.black);
	}
}

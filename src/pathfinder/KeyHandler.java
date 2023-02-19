package pathfinder;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	Panels p;
	Panels startNode;
	public KeyHandler(Panels p) {
		this.p=p;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code=e.getKeyCode();
		if(code==KeyEvent.VK_S) {
			p.setStartNode(3, 4);
		}else if(code==KeyEvent.VK_E) {
			p.setEndNode(6,7);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}

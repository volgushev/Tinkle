package game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import entities.Player;
import entities.PlayerState;


public class Controller {
	protected Player player;
	protected MouseInputHandler inputHandler;
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public MouseInputHandler getInputHandler() {
		return inputHandler;
	}

	public void setInputHandler( MouseInputHandler inputHandler ) {
		this.inputHandler = inputHandler;
	}

	public Controller() {
		inputHandler = new MouseInputHandler();
	}
	
	private class MouseInputHandler extends MouseAdapter {
		public void mousePressed( MouseEvent e ) {
			if ( e.getButton() == MouseEvent.BUTTON1 ) {
				player.setState( PlayerState.PEEING );
			}
		} 
		
		public void mouseReleased( MouseEvent e ) {
			if ( e.getButton() == MouseEvent.BUTTON1 ) {
				player.setState( PlayerState.IDLING );
			}
		}

		public void mouseDragged( MouseEvent e ) {
			int mouseX = e.getX();
			int mouseY = e.getY();
			if ( player != null ) {
				player.setTipx( mouseX );
				player.setTipy( mouseY );
			}
		}
		
		public void mouseMoved( MouseEvent e ) {
			int mouseX = e.getX();
			int mouseY = e.getY();
			if ( player != null ) {
				player.setTipx( mouseX );
				player.setTipy( mouseY );
			}
		}
	}
}



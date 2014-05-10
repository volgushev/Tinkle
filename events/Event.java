package events;
import game.GameContext;


public abstract class Event implements Comparable<Event> {
	protected int priority; 
	
	public abstract void occurIn( GameContext context );
	
	public Event( int priority ) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@Override
	public int compareTo( Event other ) {
		return Integer.compare( priority, other.getPriority() );
	}

	@Override
	public String toString() {
		return "Event [priority=" + priority + "]";
	}
	
}

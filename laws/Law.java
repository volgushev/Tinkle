package laws;

import java.util.Set;

import entities.Entity;
import events.Event;

public interface Law {
	public Set<Event> applySelfTo( Set<Entity> entities );
	public Set<Event> applySelfTo( Entity e );
}

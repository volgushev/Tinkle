package laws;

import java.util.HashSet;
import java.util.Set;

import physics.Force;
import physics.Vec2d;


import entities.Entity;
import entities.Placeable;
import entities.Player;
import events.Event;
import events.ForceEvent;
import game.Constants;

public class DragLaw implements Law {
	private static Law law = new DragLaw();
	
	public static Law get() {
		return law;
	}
	
	@Override
	public Set<Event> applySelfTo( Set<Entity> entities ) {
		Set<Event> events = new HashSet<Event>();
		for ( Entity e : entities )
			events.addAll( applySelfTo( e ) );
		return events;
	}

	@Override
	public Set<Event> applySelfTo( Entity e ) {
		Set<Event> events = new HashSet<Event>();
		if ( e instanceof Player || e instanceof Placeable )
			return events;
		Vec2d v = e.getV();
		Force f = new Force( v );
		f.getF().setMag( -Constants.drag );
		events.add(new ForceEvent(3, e, f));
		return events;
//		f.applySelfTo( e );
	}
}

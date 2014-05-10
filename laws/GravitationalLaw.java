package laws;

import java.util.HashSet;
import java.util.Set;

import physics.Force;


import entities.Entity;
import entities.Placeable;
import entities.Player;
import events.Event;
import events.ForceEvent;
import game.Constants;

public class GravitationalLaw implements Law {
	private static Law law = new GravitationalLaw();
	private static Force f = new Force( 0.0, 1.0, Constants.G );
	
	public static Law get() {
		return law;
	}
	
	@Override
	public Set<Event> applySelfTo( Set<Entity> entities ) {
		Set<Event> events = new HashSet<>();
		for ( Entity e : entities ) {
			events.addAll( applySelfTo( e ) );
		}
		return events;
	}
	
	@Override
	public Set<Event> applySelfTo( Entity e ) {
		Set<Event> events = new HashSet<>();
		if ( e instanceof Player || e instanceof Placeable )
			return events;
		events.add( new ForceEvent(3, e, f) );
		return events;
	}
}

package events;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import entities.Entity;
import game.GameContext;


public class RemoveEvent extends Event {
	private Set<Entity> entitiesToRemove;
	
	public RemoveEvent( int priority, Set<Entity> entities ) {
		super( priority );
		entitiesToRemove = entities;
	}
	
	public RemoveEvent( int priority, Entity... entities ) {
		super( priority );
		entitiesToRemove = new HashSet<>( Arrays.asList( entities ));
	}
	
	@Override
	public void occurIn( GameContext context ) {
		for ( Entity e : entitiesToRemove ) {
			context.removeEntity( e );
		}
	}
}

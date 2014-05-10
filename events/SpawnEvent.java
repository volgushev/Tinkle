package events;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import entities.Entity;
import game.GameContext;

public class SpawnEvent extends Event {
	private Set<Entity> entitiesToSpawn;
	
	public SpawnEvent( int priority, Set<Entity> entities ) {
		super( priority );
		entitiesToSpawn = entities;
	}
	
	public SpawnEvent( int priority, Entity... entities ) {
		super( priority );
		entitiesToSpawn = new HashSet<Entity>( Arrays.asList( entities ) );
	}

	@Override
	public void occurIn( GameContext context ) {
		for ( Entity e : entitiesToSpawn ) {
			context.addEntity( e );
		}
	}
}

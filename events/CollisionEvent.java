package events;

import entities.Entity;
import game.GameContext;

public class CollisionEvent extends Event {
    private Entity e1;
    private Entity e2;

    public CollisionEvent(int priority, Entity e1, Entity e2) {
	super(priority);
	this.e1 = e1;
	this.e2 = e2;
    }

    @Override
    public void occurIn(GameContext context) {
	e1.collideWith(e2);
    }

}

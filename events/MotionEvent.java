package events;

import entities.Entity;
import game.GameContext;

public class MotionEvent extends Event {
	Entity entity;
	public MotionEvent(int priority, Entity entity) {
		super(priority);
		this.entity = entity;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void occurIn(GameContext context) {
		// TODO Auto-generated method stub
		entity.move();
	}

}

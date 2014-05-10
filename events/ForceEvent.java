package events;
import physics.Force;
import entities.Entity;
import game.GameContext;


public class ForceEvent extends Event {
	private Entity target;
	private Force force;
	
	public ForceEvent(int priority, Entity target, Force force) {
		super(priority);
		this.target = target;
		this.force = force;
	}

	@Override
	public void occurIn(GameContext context) {
		force.applySelfTo(target);
	}

}

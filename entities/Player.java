package entities;

import events.Event;
import events.SpawnEvent;
import game.GameContext;

import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

import physics.Vec2d;
import sprites.Sprite;

public class Player extends Entity {
    private Member member;
    private PlayerState state;
    private Sprite sprite;

    public Member getMember() {
	return member;
    }

    public void setMember(Member member) {
	this.member = member;
    }

    public PlayerState getState() {
	return state;
    }

    public void setState(PlayerState state) {
	this.state = state;
    }

    public Player(double x, double y, double w, double h, double angle, GameContext gameContext, Sprite sprite) {
	super(x, y, w, h, angle, gameContext);
	member = new Member(x + w - 1, y + 67.0, 5.0);
	state = PlayerState.IDLING;
	this.sprite = sprite;
    }

    public void setTipx(double tipx) {
	member.tipx = tipx;
    }

    public void setTipy(double tipy) {
	member.tipy = tipy;
    }

    @Override
    public void draw(Graphics g) {
	sprite.draw(g, (int) dim.getX(), (int) dim.getY());
	// g.drawRect((int) dim.getCenterX(), (int) dim.getCenterY(), 2, 2);
	// Rectangle2D rect = new Rectangle2D.Double( dim.x, dim.y, dim.w, dim.h
	// );
	// AffineTransform transform = new AffineTransform();
	// transform.rotate( dim.angle, dim.x + dim.w/2, dim.y + dim.h/2 );
	// Shape rotatedRect = transform.createTransformedShape(rect);
	// g.setColor( Color.red );
	// ( ( Graphics2D ) g ).draw( rotatedRect );
    }

    @Override
    public Set<Event> act() {
	Set<Event> events = new HashSet<>();
	if (state.equals(PlayerState.PEEING)) {
	    events.addAll(pee());
	}
	return events;
    }

    @Override
    public void move() {
	return;
    }

    public Set<Event> pee() {
	Set<Event> events = new HashSet<>();
	Entity e = member.pee();
	events.add(new SpawnEvent(2, e));
	return events;
    }

    private class Member {
	protected double rootx;
	protected double rooty;
	protected double tipx;
	protected double tipy;

	public Member(double rootx, double rooty, double length) {
	    this.rootx = rootx;
	    this.rooty = rooty;
	    this.tipx = this.rootx + length;
	    this.tipy = this.rooty;
	}

	public Entity pee() {
	    Entity e = new Drop(rootx, rooty, 2.0, 2.0, 0.0, gameContext);
	    double mag = (Math.sqrt((tipx - rootx) * (tipx - rootx) + (tipy - rooty) * (tipy - rooty)));
	    double x = Math.abs(tipx - rootx) / mag;
	    double y = Math.abs(tipy - rooty) / mag;
	    mag = 5.0;
	    e.setV(new Vec2d(x, -y, mag));
	    return e;
	}
    }

    @Override
    public Set<Event> checkForCollisions() {
	return new HashSet<>();
    }

    @Override
    public void collideWith(Entity e) {

    }
}

package entities;

import events.Event;
import events.RemoveEvent;
import game.Constants;
import game.GameContext;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

import physics.Vec2d;
import physics.Vec2dOps;

public class Drop extends Entity {
    private Color color;

    public Drop(double x, double y, double w, double h, double angle, GameContext gameContext) {
	super(x, y, w, h, angle, gameContext);
	color = Color.black;
    }

    @Override
    public Set<Event> act() {
	Set<Event> events = new HashSet<>();
	if (v.getMag() > 0.0) {
	    checkForCollisions();
	    move();
	}

	if (dim.y > 560 || v.getMag() == 0.0) {
	    events.add(new RemoveEvent(Constants.REMOVE_PRIORITY, this));
	}
	return events;
    }

    @Override
    public void move() {
	v.add(a);
	if (v.getMag() < 0.1) {
	    v.setMag(0.0);
	}

	dim.x += v.getMag() * v.getX();
	dim.y += v.getMag() * v.getY();
	a.setX(0.0);
	a.setY(0.0);
	a.setMag(0.0);
    }

    @Override
    public void draw(Graphics g) {
	g.setColor(color);
	g.fillOval((int) dim.x, (int) dim.y, (int) dim.w, (int) dim.h);
	// g.drawLine((int) dim.x, (int) dim.y, (int) dim.x, (int) dim.y);
    }

    @Override
    public Set<Event> checkForCollisions() {
	Set<Event> events = new HashSet<>();
	for (Entity other : gameContext.getEntities()) {
	    if (other instanceof Placeable) {
		Vec2d intersection = dim.getIntersectionNormal(other.dim);
		while (intersection != null && v.getMag() > 0.0) {
		    v = Vec2dOps.get().reflect(v, intersection);
		    v.setMag(v.getMag() * 0.8);
		    move();
		    intersection = dim.getIntersectionNormal(other.dim);
		}
	    }
	}
	return events;
    }

    @Override
    public void collideWith(Entity e) {
	Vec2d intersection = dim.getIntersectionNormal(e.dim);
	if (intersection != null) {
	    v = Vec2dOps.get().reflect(v, intersection);
	    // v.setMag(v.getMag() * 0.5);
	}
    }
}

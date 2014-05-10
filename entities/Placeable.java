package entities;

import events.Event;
import game.GameContext;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.Set;

public class Placeable extends Entity {
    private Color color;

    public Placeable(double x, double y, double w, double h, double angle, GameContext gameContext, Color color) {
	super(x, y, w, h, angle, gameContext);
	this.color = color;
    }

    @Override
    public Set<Event> act() {
	return new HashSet<Event>();
    }

    @Override
    public void draw(Graphics g) {
	Rectangle2D rect = new Rectangle2D.Double(dim.x, dim.y, dim.w, dim.h);
	AffineTransform transform = new AffineTransform();
	transform.rotate(dim.angle, dim.x + dim.w / 2, dim.y + dim.h / 2);
	Shape rotatedRect = transform.createTransformedShape(rect);
	g.setColor(color);
	((Graphics2D) g).draw(rotatedRect);
    }

    @Override
    public void move() {
	return;
    }

    @Override
    public Set<Event> checkForCollisions() {
	return new HashSet<>();
    }

    @Override
    public void collideWith(Entity e) {

    }
}

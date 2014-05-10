package entities;

import events.Event;
import game.GameContext;

import java.awt.Graphics;
import java.util.Set;

import physics.Body;
import physics.Vec2d;

public abstract class Entity {
    protected Body dim;
    protected double mass;
    protected Vec2d v; // velocity
    protected Vec2d a; // acceleration
    protected GameContext gameContext;

    public double getX() {
	return dim.x;
    }

    public void setX(double x) {
	this.dim.x = x;
    }

    public double getY() {
	return dim.y;
    }

    public void setY(double y) {
	this.dim.y = y;
    }

    public double getH() {
	return dim.h;
    }

    public void setH(double h) {
	this.dim.h = h;
    }

    public double getW() {
	return dim.w;
    }

    public void setW(double w) {
	this.dim.w = w;
    }

    public Body getDim() {
	return dim;
    }

    public void setDim(Body dim) {
	this.dim = dim;
    }

    public GameContext getGameContext() {
	return gameContext;
    }

    public void setGameContext(GameContext gameContext) {
	this.gameContext = gameContext;
    }

    public Entity(double x, double y, double w, double h, double angle, GameContext gameContext) {
	this.dim = new Body(x, y, w, h, angle);
	mass = 1.0;
	this.gameContext = gameContext;
	v = new Vec2d(0.0, 0.0, 0.0);
	a = new Vec2d(0.0, 0.0, 0.0);
    }

    public double getMass() {
	return mass;
    }

    public void setMass(double mass) {
	this.mass = mass;
    }

    public Vec2d getV() {
	return v;
    }

    public void setV(Vec2d v) {
	this.v = v;
    }

    public Vec2d getA() {
	return a;
    }

    public void setA(Vec2d a) {
	this.a = a;
    }

    /*
     * Abstract methods
     */

    public abstract Set<Event> act();

    public abstract void move();

    public abstract void draw(Graphics g);

    public abstract Set<Event> checkForCollisions();

    public abstract void collideWith(Entity e);
}

package physics;

import java.awt.Rectangle;

public class Body {
    public double x; // x top left corner
    public double y; // y top left corner
    public double w;
    public double h;
    public double angle;

    public double getAngle() {
	return angle;
    }

    public void setAngle(double angle) {
	this.angle = angle;
    }

    public Body(double x, double y, double w, double h, double angle) {
	this.w = w;
	this.h = h;
	this.x = x;
	this.y = y;
	this.angle = angle;
    }

    public double getX() {
	return x;
    }

    public void setX(double x) {
	this.x = x;
    }

    public double getY() {
	return y;
    }

    public void setY(double y) {
	this.y = y;
    }

    public double getW() {
	return w;
    }

    public void setW(double w) {
	this.w = w;
    }

    public double getH() {
	return h;
    }

    public void setH(double h) {
	this.h = h;
    }

    public double getCenterX() {
	return x + w / 2;
    }

    public double getCenterY() {
	return y + h / 2;
    }

    public Vec2d getIntersectionNormal(Body other) {
	double width = 0.5 * (w + other.w);
	double height = 0.5 * (h + other.h);
	double dx = getCenterX() - other.getCenterX();
	double dy = getCenterY() - other.getCenterY();
	Vec2d intersectionVector = null;

	if (Math.abs(dx) <= width && Math.abs(dy) <= height) {
	    double wy = width * dy;
	    double hx = height * dx;
	    if (wy > hx) {
		if (wy > -hx) {
		    /* collision at the top */
		    intersectionVector = new Vec2d(0, 1, 1);
		} else {
		    /* on the left */
		    intersectionVector = new Vec2d(1, 0, 1);
		}
	    } else {
		if (wy > -hx) {
		    /* on the right */
		    intersectionVector = new Vec2d(1, 0, 1);
		} else {
		    /* at the bottom */
		    intersectionVector = new Vec2d(0, 1, 1);
		}
	    }
	}

	return intersectionVector;
    }

    public boolean overlapsWith(Body other) {
	Rectangle thisRect = new Rectangle((int) this.x, (int) this.y, (int) this.w, (int) this.h);
	Rectangle otherRect = new Rectangle((int) other.x, (int) other.y, (int) other.w, (int) other.h);
	return thisRect.intersects(otherRect);
    }
}

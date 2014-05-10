package physics;

public class Vec2d {
    private double x;
    private double y;
    private double mag;

    public Vec2d(double x, double y, double mag) {
	this.x = x;
	this.y = y;
	this.mag = mag;
    }

    public Vec2d(Vec2d other) {
	this.x = other.getX();
	this.y = other.getY();
	this.mag = other.getMag();
    }

    @Override
    public String toString() {
	return "Vec2d [x=" + x + ", y=" + y + ", mag=" + mag + "]";
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

    public double getMag() {
	return mag;
    }

    public void setMag(double mag) {
	this.mag = mag;
    }

    public void subtract(Vec2d other) {
	this.x *= mag;
	this.y *= mag;
	this.x -= other.getMag() * other.getX();
	this.y -= other.getMag() * other.getY();
	normalize();
    }

    public void add(Vec2d other) {
	this.x *= mag;
	this.y *= mag;
	this.x += other.getMag() * other.getX();
	this.y += other.getMag() * other.getY();
	normalize();
    }

    public void divide(double scalar) {
	mag /= scalar;
    }

    public void multiply(double scalar) {
	mag *= scalar;
    }

    public double dot(Vec2d other) {
	return mag * x * other.getMag() * other.getX() + mag * y * other.getMag() * other.getY();
    }

    private void normalize() {
	mag = Math.sqrt(x * x + y * y);
	this.x /= mag;
	this.y /= mag;
    }
}

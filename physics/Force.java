package physics;

import java.util.Set;

import entities.Entity;


public class Force {
	private Vec2d f;
	
	public Vec2d getF() {
		return f;
	}

	public void setF(Vec2d f) {
		this.f = f;
	}

	public Force( Vec2d f ) {
		this.f = new Vec2d( f );
	}
	
	public Force( double x, double y, double mag ) {
		this.f = new Vec2d( x, y, mag );
	}
	
	public void applySelfTo( Set<Entity> entities ) {
		for ( Entity e : entities ) {
			applySelfTo( e );
		}
	}
	
	public void applySelfTo( Entity e ) {
		// not sure if this is a good idea
		f.divide( e.getMass() );
		e.getA().add( f );
		f.multiply( e.getMass() );
	}
}

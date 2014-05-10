package physics;

public class Vec2dOps {

	private static Vec2dOps singleton = new Vec2dOps();

	public static Vec2dOps get() {
		return singleton;
	}
	// return vector - 2 * Vector2.Dot(vector, normal) * normal;

	public Vec2d reflect(Vec2d v1, Vec2d n) {
		Vec2d ref = new Vec2d(v1);
		Vec2d nCopy = new Vec2d(n);
		nCopy.multiply(2.0);
		nCopy.multiply(v1.dot(n));
		ref.subtract(nCopy);
		return ref;
	}
}

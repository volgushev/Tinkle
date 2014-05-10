package sprites;
import java.util.Iterator;
import java.util.List;


public class SpriteSequence {
	private List<Sprite> sprites;
	private Iterator<Sprite> iterator;
	
	public SpriteSequence( List<Sprite> sprites ) {
		this.sprites = sprites;
		iterator = this.sprites.iterator();
	}
	
	public Sprite nextSprite() {
		if ( !iterator.hasNext() ) {
			iterator = this.sprites.iterator(); // reset to head
		}
		return iterator.next();
	}

	public void reset() {
		iterator = this.sprites.iterator();
	}
}

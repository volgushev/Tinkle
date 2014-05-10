package game;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import laws.DragLaw;
import laws.GravitationalLaw;
import laws.Law;
import sprites.Sprite;
import sprites.SpriteStore;
import entities.Entity;
import entities.Placeable;
import entities.Player;

public class GameContext {
    private Set<Entity> entities;
    private Player player;
    private Set<Law> laws;

    public GameContext() {
	initEntities();
	initLaws();
    }

    public Set<Entity> getEntities() {
	return entities;
    }

    public void setEntities(Set<Entity> entities) {
	this.entities = entities;
    }

    public Player getPlayer() {
	return player;
    }

    public void setPlayer(Player player) {
	this.player = player;
    }

    public Set<Law> getLaws() {
	return laws;
    }

    public void setLaws(Set<Law> laws) {
	this.laws = laws;
    }

    private void initLaws() {
	laws = new HashSet<Law>();
	laws.add(GravitationalLaw.get());
	laws.add(DragLaw.get());
    }

    private void initEntities() {
	entities = new HashSet<Entity>();
	Sprite playerSprite = SpriteStore.get().getSprite("resources/right.jpg");
	player = new Player(130, 450, playerSprite.getWidth(), playerSprite.getHeight(), Math.toRadians(0), this, playerSprite);
	entities.add(player);
	entities.add(new Placeable(500, 450, 100, playerSprite.getHeight(), Math.toRadians(0), this, Color.black));
	entities.add(new Placeable(200, 500, 100, 60, Math.toRadians(0), this, Color.black));
    }

    public void addEntity(Entity e) {
	entities.add(e);
    }

    public void removeEntity(Entity e) {
	if (entities.contains(e)) {
	    entities.remove(e);
	}
    }

    public void removeEntities(Set<Entity> entities) {
	for (Entity e : entities) {
	    if (entities.contains(e)) {
		entities.remove(e);
	    }
	}
    }
}

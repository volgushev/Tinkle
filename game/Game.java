package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

import laws.Law;
import entities.Entity;
import entities.Player;
import events.Event;
import events.EventHandler;

public class Game extends Canvas {
    private static final long serialVersionUID = 1L;
    private BufferStrategy strategy;
    private GameContext gameContext;
    private Controller controller;
    private EventHandler handler;

    public Game() {
	JFrame container = new JFrame("Foo");

	JPanel panel = (JPanel) container.getContentPane();
	panel.setPreferredSize(new Dimension(800, 600));
	panel.setLayout(null);

	setBounds(0, 0, 800, 600);
	panel.add(this);

	setIgnoreRepaint(true);

	container.pack();
	container.setResizable(false);
	container.setVisible(true);

	container.addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent e) {
		System.exit(0);
	    }
	});

	controller = new Controller();
	addMouseListener(controller.getInputHandler());
	addMouseMotionListener(controller.getInputHandler());
	requestFocus();

	createBufferStrategy(2);
	strategy = getBufferStrategy();
    }

    private void startGame() {
	gameContext = new GameContext();
	controller.setPlayer(gameContext.getPlayer());
	handler = EventHandler.get();
	handler.setContext(gameContext);
	gameLoop();
    }

    public void gameLoop() {
	int counter = 0;

	while (true) {
	    counter++;
	    if (counter % 5 == 0) {
		try {
		    Thread.sleep(1);
		} catch (Exception e) {
		}
		counter = 0;
		continue;
	    }
	    Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
	    g.setColor(Color.white);
	    g.fillRect(0, 0, 800, 600);

	    Set<Entity> entities = gameContext.getEntities();
	    Set<Law> laws = gameContext.getLaws();
	    Set<Event> events = new HashSet<Event>();

	    events.addAll(gameContext.getPlayer().act());

	    for (Law l : laws) {
		events.addAll(l.applySelfTo(entities));
	    }

	    for (Entity e : entities) {
		if (!(e instanceof Player)) {
		    events.addAll(e.act());
		}
	    }

	    handler.processEvents(events);

	    for (Entity e : entities) {
		e.draw(g);
	    }

	    g.dispose();
	    strategy.show();
	}
    }

    public static void main(String argv[]) {
	Game g = new Game();
	g.startGame();
    }
}

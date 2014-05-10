package events;

import game.GameContext;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class EventHandler {
    private static EventHandler handler = new EventHandler();
    private GameContext context;

    public static EventHandler get() {
	return handler;
    }

    public void setContext(GameContext context) {
	this.context = context;
    }

    public GameContext getContext() {
	return context;
    }

    public void processEvents(Set<Event> events) {
	Queue<Event> queue = new PriorityQueue<>(events);
	while (!queue.isEmpty()) {
	    Event e = queue.poll();
	    e.occurIn(context);
	}
    }
}


/**
* The <code>Heap</code> class implements a heap of <code>HeapItem</code>
* objects.
*    
*
* @author Mingtong Wu
*    e-mail: mingtong.wu@stonybrook.edu
*    Stony Brook ID:110033615
**/package javafxapplication5;
import java.util.*;

public class Router extends LinkedList {
	private int id;
	private LinkedList<Packet> packets = new Packet();
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LinkedList<Packet> getPackets() {
		return this.packets;
	}

	public Router(int id) {
		this.setId(id);
	}

	public int check(int time) {
		Packet a = new Packet();
		if (!((Packet) this.packets).isEmpty() && ((Packet) this.packets.peekFirst()).isDone()) {
			a = ((Packet) this.packets.pollFirst());
			System.out.printf("Packet %d has successfully reached its destination: +%d%n", a.getId(),
					time - a.getTimeArrive());
			return time - a.getTimeArrive();
		}
		return 0;
	}

	@SuppressWarnings("rawtypes")
	public static int sendPacketTo(Collection routers, int max) throws Exception {
		// TODO exception
		int size = max, id = -1;// start with Router 1.
		for (int k = 0; k < ((LinkedList<Router>) routers).size(); k++) {
			if (((LinkedList<Router>) routers).get(k).getPackets().size() < size
					&& ((LinkedList<Router>) routers).get(k).getPackets().size() < max) {
				size = ((LinkedList<Router>) routers).get(k).getPackets().size();
				id = ((LinkedList<Router>) routers).get(k).getId();
			}
		}
		if (id == -1)
			throw new Exception("routers are full.");
		return id - 1;
	}

	// @override
	public String toString() {
		String a = "{";
		for (int k = 0; k < packets.size(); k++) {
			a += (packets.get(k)).toString() + ", ";
		}
		a += "}\n";
		return a;
	}
}

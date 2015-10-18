import java.util.*;

public class Simulator {
	private Router dispatcher = new Router(1);
	private LinkedList<Router> routers = new LinkedList<Router>();
	private int totalServiceTime =0, totalPacketsArrived=0, packetsDropped, numIntRouters, maxBufferSize, maxPacketSize,
			minPacketSize, bandwidth, duration;
	private double arrivalProb;

	public int getTotalServiceTime() {
		return this.totalServiceTime;
	}

	public int getTotalPacketsArrived() {
		return this.totalPacketsArrived;
	}

	public int getPacketsDropped() {
		return this.packetsDropped;
	}

	public int getNumIntRouters() {
		return this.numIntRouters;
	}

	public int getMaxBufferSize() {
		return this.maxBufferSize;
	}

	public int getMaxPacketSize() {
		return this.maxPacketSize;
	}

	public int getMinPacketSize() {
		return this.minPacketSize;
	}

	public int getBandwidth() {
		return this.bandwidth;
	}

	public int getDuration() {
		return this.duration;
	}

	public double getArrivalProb() {
		return this.arrivalProb;
	}

	public void setTotalPacketsArrived(int totalArrived) {
		this.totalPacketsArrived = totalArrived;
	}

	public void setTotalServiceTime(int totalServiceTime) {
		this.totalServiceTime = totalServiceTime;
	}

	public void setPacketDropped(int packetDropped) {
		this.packetsDropped = packetDropped;
	}

	public void setNumIntRouters(int numIntRouters) {
		this.numIntRouters = numIntRouters;
	}

	public void setMaxBufferSize(int maxBufferSize) {
		this.maxBufferSize = maxBufferSize;
	}

	public void setMaxPacketSize(int maxPacketSize) {
		this.maxPacketSize = maxPacketSize;
	}

	public void setMinPacketSize(int minPacketSize) {
		this.minPacketSize = minPacketSize;
	}

	public void setBandwidth(int bandwidth) {
		this.bandwidth = bandwidth;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setArrivalProb(double arrivalProb) {
		this.arrivalProb = arrivalProb;
	}

	private void status() {
		for (int k = 0; k < this.numIntRouters; k++) {
			System.out.println(routers.get(k).toString());
		}

	}

	public double simulate() {
		int num = 0;
		for (int k = 0; k < this.numIntRouters; k++) {
			routers.add(new Router(k+1));
		}
		while(this.totalServiceTime<this.duration){
			this.totalServiceTime++;
		System.out.printf("Time: %d%n", this.totalServiceTime);
		num = (int) ((this.numIntRouters + 1) * Math.random());
		for (int k = 0; k < num; k++) {
			//TODO when it close to max
			this.dispatcher.addLast(new Packet(Packet.getPacketCounter(), this.randInt(this.minPacketSize, this.maxPacketSize),this.totalServiceTime));
			System.out.printf("Packet %d arrives at dispatcher with size %d.%n",
					((Packet) this.dispatcher.getLast()).getId(), ((Packet) this.dispatcher.getLast()).getPacketSize());
		}
		while (!this.dispatcher.isEmpty()) {
			int routerId;
			System.out.printf("Packet %d sent to Router %d.%n",
					((Packet) this.dispatcher.getFirst()).getId(), routers.get(Router.sendPacketTo(routers,this.maxBufferSize)).getId());
			routers.get(Router.sendPacketTo(routers,this.maxBufferSize)).getPackets().addLast((Packet) this.dispatcher.pollFirst()); 
			this.totalPacketsArrived++;
			//TODO  exception and drop
		}
		for (int k = 0; k < num; k++) {
			System.out.println("Packet 5 has successfully reached its destination: +8");
		}
		this.status();
		}
		return 0;
	}

	private int randInt(int minVal, int maxVal) {
		return (int) (Math.random() * ( maxVal + 1-minVal) + minVal);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Simulator a = new Simulator();
		System.out.println("Starting simulator...");
		System.out.println("Enter the number of Intermediate routers:");
		//a.setNumIntRouters(input.nextInt());
		a.setNumIntRouters(4);
		a.setArrivalProb(0.5);
		a.setMaxBufferSize(10);
		a.setMinPacketSize(500);
		a.setMaxPacketSize(1500);
		a.setBandwidth(2);
		a.setDuration(25);
		System.out.println("Enter the arrival probability of a packet:");
		//a.setArrivalProb(input.nextDouble());
		System.out.println("Enter the maximum buffer size of a router:");
		//a.setMaxBufferSize(input.nextInt());
		System.out.println("Enter the minimum size of a packet:");
		//a.setMinPacketSize(input.nextInt());
		System.out.println("Enter the maximum size of a packet:");
		//a.setMaxPacketSize(input.nextInt());
		System.out.println("Enter the bandwidth size:");
		//a.setBandwidth(input.nextInt());
		System.out.println("Enter the simulation duration:");
		//a.setDuration(input.nextInt());
double b =a.simulate();
	}
}

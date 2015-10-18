import java.util.*;

public class Simulator {
	private Router dispatcher;
	private Collection<Router> routers;
	private int totalServiceTime, totalPacketsArrived, packetsDropped, numIntRouters, maxBufferSize, maxPacketSize,
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

public int getMaxPacketSize(){
	return this.maxPacketSize;
}
public int getMinPacketSize(){
	return this.minPacketSize;
}
public int getBandwidth(){
	return this.bandwidth;
}
public int getDuration(){
	return this.duration;
}
public double getArrivalProb(){
	return this.arrivalProb;
}
public void setTotalPacketsArrived(int totalArrived){
	this.totalPacketsArrived = totalArrived;
}
public void setTotalServiceTime(int totalServiceTime){
	this.totalServiceTime = totalServiceTime;
}
public void setPacketDropped(int packetDropped){
	this.packetsDropped = packetDropped;
}
public void setNumIntRouters(int numIntRouters){
	this.numIntRouters = numIntRouters;
}
public void setMaxBufferSize(int maxBufferSize){
	this.maxBufferSize = maxBufferSize;
}
public void setMaxPacketSize(int maxPacketSize){
	this.maxPacketSize = maxPacketSize;
}
public void setMinPacketSize(int minPacketSize){
	this.minPacketSize = minPacketSize;
}
public void setBandwidth(int bandwidth){
	this.bandwidth = bandwidth;
}
public void setDuration(int duration){
	this.duration = duration;
}
public void setArrivalProb(double arrivalProb){
	this.arrivalProb = arrivalProb;
}
	private double simulate() {
		
	}

	private int randInt(int minVal, int maxVal) {
		return (int) (Math.random() * (minVal + maxVal + 1) - minVal);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Simulator a = new Simulator();
		System.out.println("Starting simulator...");
		System.out.println("Enter the number of Intermediate routers:");
		a.setNumIntRouters(input.nextInt());
		System.out.println("Enter the arrival probability of a packet:");
		a.setArrivalProb(input.nextDouble());
		System.out.println("Enter the maximum buffer size of a router:");
		a.setMaxBufferSize(input.nextInt());
		System.out.println("Enter the minimum size of a packet:");
		a.setMinPacketSize(input.nextInt());
		System.out.println("Enter the maximum size of a packet:");
		a.setMaxPacketSize(input.nextInt());
		System.out.println("Enter the bandwidth size:");
		a.setBandwidth(input.nextInt());
		System.out.println("Enter the simulation duration:");
		a.setDuration(input.nextInt());

	}
}

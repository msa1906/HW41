
/**
* The <code>Heap</code> class implements a heap of <code>HeapItem</code>
* objects.
*    
*
* @author Mingtong Wu
*    e-mail: mingtong.wu@stonybrook.edu
*    Stony Brook ID:110033615
**/
package simulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.*;

public class Simulator extends Application {
	private Router dispatcher = new Router(1);
	private LinkedList<Router> routers = new LinkedList<Router>();
	private int totalServiceTimePerPacket = 0, totalServiceTime = 1, totalPacketsArrived = 0, packetsDropped = 0,
			numIntRouters, maxBufferSize, maxPacketSize, minPacketSize, bandwidth, duration;
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
			routers.add(new Router(k + 1));
		}
		do{
			System.out.printf("Time: %d%n", this.totalServiceTime);
			num = (int) ((this.numIntRouters + 1) * Math.random());
			for (int k = 0; k < num; k++) {
				this.dispatcher.addLast(new Packet(Packet.getPacketCounter(),
						this.randInt(this.minPacketSize, this.maxPacketSize), this.totalServiceTime));
				System.out.printf("Packet %d arrives at dispatcher with size %d.%n",
						((Packet) this.dispatcher.getLast()).getId(),
						((Packet) this.dispatcher.getLast()).getPacketSize());
			}
			while (!this.dispatcher.isEmpty()) {
				try {
					System.out.printf("Packet %d sent to Router %d.%n", ((Packet) this.dispatcher.getFirst()).getId(),
							routers.get(Router.sendPacketTo(routers, this.maxBufferSize)).getId());
					routers.get(Router.sendPacketTo(routers, this.maxBufferSize)).getPackets()
							.addLast((Packet) this.dispatcher.pollFirst());
					this.totalPacketsArrived++;
				} catch (Exception e) {
					System.out.printf("Network is congested. Packet %d is dropped.%n",
							((Packet) this.dispatcher.getFirst()).getId());
					this.dispatcher.pollFirst();
					this.packetsDropped++;
				}
				for (int k = 0; k < this.numIntRouters; k++) {
					this.totalServiceTimePerPacket += this.routers.get(k).check(this.totalServiceTime);
				}

			}
			this.status();
		}while (++this.totalServiceTime-1 < this.duration);
			System.out.println("Simulation ending...");
		System.out.printf(
				"Total service time: %d%nTotal packets served: %d%nAverage service time per packet: %.3f%nTotal packets dropped: %d%n",
				this.totalServiceTime-1, this.totalPacketsArrived,
				(double) this.totalServiceTimePerPacket / this.totalPacketsArrived, this.packetsDropped);
		return (double) this.totalServiceTimePerPacket / this.totalPacketsArrived;
	}

	private int randInt(int minVal, int maxVal) {
		return (int) (Math.random() * (maxVal + 1 - minVal) + minVal);
	}
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Simulator.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Simulator");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
	
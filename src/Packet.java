import java.util.*;
public abstract class Packet implements Queue{
public static int packetCount;
private int id, packetSize, timeArrive, timeToDest;
public Packet(){}
public int getId(){
	return this.id;
}
public int getPacketSize(){
	return this.packetSize;
}
public int getTimeArrive(){
	return this.timeArrive;
}
public int getTimeToDest(){
	return this.timeToDest;
}
public void setId(int id){
	this.id = id;
}
public void setPacketSize(int packetSize){
	this.packetSize = packetSize;
}
public void setTimeArrive(int timeArrive){
	this.timeArrive = timeArrive;
}
public void setTimeToDest(int timeToDest){
	this.timeToDest = timeToDest;
}
public String toString(){
	String a = "";
	a.format("[%d, %d, %d]", id, timeArrive, timeToDest);
	return a;
}
}

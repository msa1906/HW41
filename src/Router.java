import java.util.*;
public abstract class Router implements Queue{
	private int id;
	private Queue<Packet> packets;
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
public Router(){}
public static int sendPacketTo(Collection routers){
	int size = 0,id = 1;//start with Router 1.
	for(Object o: routers){
		if(((Router)o).size()>size){
			size = ((Router)o).size();
			id = ((Router)o).id;
		}
	}
	return id;
}
//@override
public String toString(){
	String a ="{";
	for(Object o: packets){
		a+=((Packet)o).toString()+", ";
	}
	a +="}";
	return a;
}
}

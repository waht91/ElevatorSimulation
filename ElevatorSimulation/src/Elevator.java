import java.util.ArrayList;
import java.util.List;

public class Elevator {
	
	private int id;
	private int cfloor;
	private int dfloor;
	private String direction="IDLE";
	private boolean flag=false;
	private List<Passenger> passengers;

	public Elevator (int id, int cfloor) {
		this.id = id;
		this.cfloor = cfloor;
		this.dfloor = cfloor;
		this.passengers = new ArrayList<Passenger>();
	}
	public String getStatus (){
		return direction;
	}
	public List<Passenger> getpassengers() {
		return passengers;
	}
	public int getcfloor() {
		return cfloor;
	}
	public int getdfloor() {
		return dfloor;
	}
	public boolean isEmpty() {
		return passengers.isEmpty();
	}
	public void setdirection(int df) {
		this.dfloor = df;
		this.direction = getDirection(cfloor, dfloor);
	}
	public static double onedigit (double a){
		int temp = (int)(a*10.0);
		double b = ((double)temp)/10.0;
		return b;
	}
	public boolean stopmoving(){
		if(cfloor == dfloor) {
			direction = "IDLE";
			return true;
		}else {
			return false;
		}
	}
	public void addPassenger(Passenger pp, double currentTime){
		pp.SetWait(currentTime-pp.getArrival());
		passengers.add(pp);
	}
	public void TakeOff() {
		for(int i = 0; i<passengers.size(); i++ ) {
			if(cfloor == passengers.get(i).getdfloor()) {
				System.out.println("Elevator ID: "+ this.id
									+"\tPassenger id:"+passengers.get(i).getid()
									+"\tArrival Time: "+passengers.get(i).getArrival()
									+"\tLeaving Time: "+passengers.get(i).getLeavingTime() 
									+"\tFrom floor: "+passengers.get(i).getcfloor()
									+"\tTo  "+passengers.get(i).getdfloor()
									+"\tWait Time: "+onedigit (passengers.get(i).getWait()));
				passengers.remove(i);
			}
		}
	}
	public int nextFloor() {	
		if(cfloor == dfloor) {
			direction = "IDLE";
			return this.cfloor;
		}else if (direction == "UP") {
			return (this.cfloor += 1);
		} else if (direction == "DOWN") {
			return (this.cfloor -= 1);
		} else {
			return this.cfloor;
		}
	}
	public static String getDirection(int currentFloor, int destinationFloor) {
		int dir = destinationFloor - currentFloor;
		if (dir < 0) {
			return "DOWN";
		} else if (dir > 0) {
			return "UP";
		} else {
			return "IDLE";
		}
	}
}

/*
 *
 *
	public int getid() {
		return id;
	}
	public int getcfloor() {
		return cfloor;
	}
	public int getdfloor() {
		return dfloor;
	}
	public String getdirection() {
		return direction;
	}
 *
 *
 *
 */


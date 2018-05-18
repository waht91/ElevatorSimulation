import java.util.ArrayList;
import java.util.List;

public class Elevator {
	
	private int id;
	private int cfloor;
	private int dfloor;
	private String direction;
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
	public boolean isEmpty() {
		return passengers.isEmpty();
	}
	public void setdirection(int df) {
		this.dfloor = df;
		this.direction = getDirection(cfloor, dfloor);
	}
	public void stopmoving(){
		direction = "IDLE";
	}
	public void addPassenger(Passenger pp, double currentTime){
		pp.SetWait(currentTime-pp.getArrival());
		passengers.add(pp);
	}
	public List<Passenger> TakeOff() {
		List<Passenger> offPassenger = new ArrayList<Passenger>();
		System.out.println("Elevator #"+id+" TakeOff Passengers");
		for(int i = 0; i<passengers.size(); i++ ) {
			if(cfloor == passengers.get(i).getdfloor()) {
				System.out.println("Passenger id:"+passengers.get(i).getid()
									+"Passenger Arrival Time: "+passengers.get(i).getArrival()
									+"From floor: "+passengers.get(i).getcfloor()
									+"To floor : "+passengers.get(i).getdfloor()
									+"Wait Time: "+passengers.get(i).getWait());
				offPassenger.add(passengers.remove(i));
			}
		}
		return offPassenger;
	}
	public int nextFloor() {		
		if (direction == "UP") {
			return this.cfloor + 1;
		} else if (direction == "DOWN") {
			return this.cfloor - 1;
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


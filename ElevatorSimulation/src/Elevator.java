import java.util.ArrayList;
import java.util.List;

public class Elevator {

	private int id;
	private int cfloor;
	private int dfloor;
	private String direction = "IDLE";
	private boolean flag = false;
	private List<Passenger> passengers;

	public Elevator(int id, int cfloor) {
		this.id = id;
		this.cfloor = cfloor;
		this.dfloor = cfloor;
		this.passengers = new ArrayList<Passenger>();
	}

	public String getStatus() {
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
		System.out.println("Direction: "+direction+" To: "+dfloor);
	}

	public void setMoving(int df) {
		System.out.println("Elevator Heading floor: "+ df);
		this.dfloor = df;
		this.direction = "MOVING";
	}

	public static double onedigit(double a) {
		int temp = (int) (a * 10.0);
		double b = ((double) temp) / 10.0;
		return b;
	}

	public void stopmoving() {
		System.out.println("Waiting");
		direction = "WAITING";
	}

	public void addPassenger(Passenger pp, double currentTime) {
		pp.SetWait(currentTime - pp.getArrival());
		passengers.add(pp);
	}

	public void TakeOff() {
		for (int i = 0; i < passengers.size(); i++) {
			if (cfloor == passengers.get(i).getdfloor()) {
				System.out.println("Elevator ID: " + this.id + "\tPassenger id:" + passengers.get(i).getid()
						+ "\tArrival Time: " + passengers.get(i).getArrival() + "\tLeaving Time: "
						+ passengers.get(i).getLeavingTime() + "\tFrom floor: " + passengers.get(i).getcfloor()
						+ "\tTo  " + passengers.get(i).getdfloor() + "\tWait Time: "
						+ onedigit(passengers.get(i).getWait()));
				passengers.remove(i);
			}
		}
	}

	public void nextFloor() {
		if(cfloor != dfloor) {
			if(direction == "MOVING") {
				if(cfloor>dfloor) {
					System.out.println("Moving Down :"+cfloor);
					cfloor--;
				}else if(dfloor>cfloor) {
					System.out.println("Moving Up :"+cfloor);
					cfloor++;
				}
			}
			if (direction == "UP") {
				System.out.println("Up");
				if(dfloor>cfloor)
					cfloor ++;
			} else if (direction == "DOWN") {
				System.out.println("Down");
				if(dfloor<cfloor)
					cfloor --;
			}
		}else {
			
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
 * public int getid() { return id; } public int getcfloor() { return cfloor; }
 * public int getdfloor() { return dfloor; } public String getdirection() {
 * return direction; }
 *
 *
 *
 */

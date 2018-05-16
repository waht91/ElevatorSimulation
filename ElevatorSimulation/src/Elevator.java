import java.util.ArrayList;
import java.util.List;

public class Elevator {
	
	private int id;
	private int cfloor;
	private int dfloor;
	private String direction;
	private List<Passenger> passengers;
	private State state = State.IDLE;
	public static enum State {
		IDLE,
		MOVING
	}
	public Elevator (int id, int cfloor) {
		this.id = id;
		this.cfloor = cfloor;
		this.dfloor = cfloor;
		this.passengers = new ArrayList<Passenger>();
	}
	public boolean getStatus (){
		if(this.state == State.IDLE){
			return true;
		}else{
			return false;
		}
	}
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
		this.direction = "STOP";
		this.state = State.IDLE;
		
	}
	public void getThisElevator(int c, int d){
		setdirection(d);
		this.state = State.MOVING;
	}
	public int nextFloor() {		
		if (this.state == State.MOVING) {
			if (this.direction.equals("UP")) {
				return this.cfloor + 1;
			} else if (this.direction.equals("DOWN")) {
				return this.cfloor - 1;
			} else {
				return this.cfloor;
			}
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
			return "ARRIVED";
		}
	}
}

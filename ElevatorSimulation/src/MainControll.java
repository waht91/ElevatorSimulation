import java.util.List;
import java.util.Queue;

public class MainControll {

	private List<Elevator> Elevators;
	private List<Floor> Floors;
	private int[] floorSign = { 99, 99, 99, 99, 99 };

	public MainControll(List<Elevator> e, List<Floor> f) {
		this.Elevators = e;
		this.Floors = f;
	}

	public void addElevator(Elevator newElevator) {
		this.Elevators.add(newElevator);
	}

	public void addFloor(Floor newFloor) {
		this.Floors.add(newFloor);
	}

	public Floor getFloor(int index) {
		return Floors.get(index);
	}

	public void signal(int fid) {
		floorSign[0] = fid;
	}

	public void tookoff() {
		for (int i = 0; i < Elevators.size(); i++) {
			Elevators.get(i).TakeOff();

		}
	}
	public void requestElevator(double currentTime) {
		for (int i = 0; i < Elevators.size(); i++) {
			Elevators.get(i).nextFloor();
			if (Elevators.get(i).getStatus() == "IDLE") {
				if(floorSign[i] <10) {
					System.out.println("Elevator id:"+ i +" is IDLE At "+Elevators.get(i).getcfloor());
					Elevators.get(i).setMoving(floorSign[i]);
				}
			}
			if (Elevators.get(i).getcfloor() == floorSign[i]) {
				System.out.println("Elevator Reached floor: "+floorSign[i]);
				Elevators.get(i).stopmoving();
				if(Floors.get(floorSign[i]).ButtonSign() == "UP") {
					List<Passenger> boarding = Floors.get(floorSign[i]).GetGoingUpDown();
					System.out.print("Boarding Passenger id: ");
					for(int b = 0; b < boarding.size(); b++) {
						if(boarding.get(b).getWay() == "UP") {
							System.out.print(boarding.get(b).getid()+ " ");
							Elevators.get(i).addPassenger(boarding.remove(b), currentTime);
						}
					}
					System.out.println();
					Elevators.get(i).setdirection(9);
					System.out.println("Elevator Going UP");
					
					
				} else if(Floors.get(floorSign[i]).ButtonSign() == "DOWN") {
					List<Passenger> boarding = Floors.get(floorSign[i]).GetGoingUpDown();
					System.out.print("Boarding Passenger id: ");
					for(int b = 0; b < boarding.size(); b++) {
						if(boarding.get(b).getWay() == "DOWN") {
							System.out.print(boarding.get(b).getid()+ " ");
							Elevators.get(i).addPassenger(boarding.remove(b), currentTime);
						}
					}
					System.out.println();
					Elevators.get(i).setdirection(0);
					System.out.println("Elevator Going Down");
				}
				floorSign[0] = 99;
			}
		}
	}

	public void RunElevator(double currentTime) {
		requestElevator(currentTime);
/*		for (int i = 0; i < Elevators.size(); i++) {
			int av = Elevators.get(i).getcfloor();
			System.out.println(av);
			if (Floors.get(av).UpDownSize() > 0) {
				List<Passenger> UpDownPass = Floors.get(av).GetGoingUpDown();
				for (int x = 0; x < UpDownPass.size(); x++) {
					if (UpDownPass.get(x).getWay() == "UP") {
						Elevators.get(i).addPassenger(UpDownPass.remove(x), currentTime);
					} else if (UpDownPass.get(x).getWay() == "DOWN") {
						Elevators.get(i).addPassenger(UpDownPass.remove(x), currentTime);
					}
				}
			}
			// System.out.println(Elevators.get(i).getpassengers().size());
			Elevators.get(i).TakeOff();
			// System.out.println(Elevators.get(i).getcfloor()+"
			// "+Elevators.get(i).getdfloor() + " " + Elevators.get(i).getStatus());
			Elevators.get(i).nextFloor();
		}
*/
	}
}

import java.util.List;
import java.util.Queue;

public class MainControll {

	private List<Elevator> Elevators;
	private List<Floor> Floors;
	public MainControll (List<Elevator> e ,List<Floor> f) {
		this.Elevators = e;
		this.Floors =  f;
	}
	public void addElevator (Elevator newElevator){
		this.Elevators.add(newElevator);
	}
	public void addFloor (Floor newFloor){
		this.Floors.add(newFloor);
	}
	public Floor getFloor (int index){
		return Floors.get(index);
	}
	public void addPassenger (Passenger newPass) {
		Floors.get(newPass.getcfloor()).addPassenger(newPass);
	}
	public void timer (){
		for(int i =0; i<Elevators.size();i++){
			Elevators.get(i).nextFloor();
		}
	}
	public boolean checkFloors (){
		for (int i = 0; i<Floors.size();i++){
			if(Floors.get(i).UpSize()>0 || Floors.get(i).DownSize()>0){
				return true;
			}
		}
		return false;
	}
	public int checkF (){
		int ff=0;
		for (int i = 0; i<Floors.size();i++){
			if(Floors.get(i).UpSize()>0 || Floors.get(i).DownSize()>0){
				ff=i;
//				System.out.println(ff);
			}
		}
		return ff;
	}
	public void tookoff() {
		for(int i = 0; i<Elevators.size(); i++) {
			Elevators.get(i).TakeOff();
			
		}
	}
	public void requestElevator () {
		for(int i = 0; i<Elevators.size(); i++) {
			if(Elevators.get(i).getStatus() == "IDLE") {
				int cf = checkF();
//				System.out.println(Elevators.get(i).getcfloor()+" "+cf);
				if(Elevators.get(i).getcfloor() > cf ) {
//					System.out.println("Elevator Heading down");
					Elevators.get(i).setdirection(0);
				}else if (Elevators.get(i).getcfloor() < cf){
//					System.out.println("Elevator Heading Up");
					Elevators.get(i).setdirection(Floors.size()-1);
				}
			}
		}
	}
	public void RunElevator (double currentTime) {
		timer ();
		requestElevator();
		for(int i = 0; i<Elevators.size(); i++) {
			if(Elevators.get(i).getStatus() == "UP") {
				int av = Elevators.get(i).getcfloor();
				if(Floors.get(av).UpSize()>0) {
					List<Passenger> UpPass = Floors.get(av).GetGoingUp();
					for (int x = 0; x < UpPass.size(); x ++ ) {
						Elevators.get(i).addPassenger(UpPass.remove(x), currentTime);
					}
				}
			}
			if(Elevators.get(i).getStatus() == "DOWN") {
				int av = Elevators.get(i).getcfloor();
				if(Floors.get(av).DownSize()>0) {
					List<Passenger> DownPass = Floors.get(av).GetGoingDown();
					for (int x = 0; x < DownPass.size(); x ++ ) {
						Elevators.get(i).addPassenger(DownPass.remove(x), currentTime);
					}
				}
			}
//			System.out.println(Elevators.get(i).getpassengers().size());
			Elevators.get(i).TakeOff();
//			System.out.println(Elevators.get(i).getcfloor()+" "+Elevators.get(i).getdfloor() + " " + Elevators.get(i).getStatus());
			Elevators.get(i).nextFloor();
		}
	}
}

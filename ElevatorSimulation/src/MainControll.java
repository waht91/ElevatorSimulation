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
				Elevators.get(i).setdirection(checkF());
			}
		}
	}
	public void refreshElevator () {
		
	}
}

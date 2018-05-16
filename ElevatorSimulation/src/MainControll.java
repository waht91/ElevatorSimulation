import java.util.ArrayList;
import java.util.List;

public class MainControll {

	private int Sig[] = new int[10];
	private List<Elevator> Elevators;
	private List<Floor> Floors;
	public MainControll (List<Floor> b) {
		this.Elevators = new ArrayList<Elevator>();
		this.Floors =  b;
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
	public void timepassone (){
		for(int i =0; i<Elevators.size();i++){
			Elevators.get(i).nextFloor();
		}
	}
	public void requestE (){
		
	}
	public boolean checkFloors (){
		for (int i = 0; i<Floors.size();i++){
			if(Floors.get(i).FloorDirection() == "UP" || Floors.get(i).FloorDirection() == "DOWN"){
				return true;
			}
		}
		return false;
	}
	public boolean checkAvailability (){
		for (int i=0; i<Elevators.size();i++){
			if(Elevators.get(i).getStatus()){
				return true;
			}
		}
		return false;
	}
}

import java.util.ArrayList;
import java.util.List;

public class Floor {

	private int id;
	private List<Passenger> GoingUp;
	private List<Passenger> GoingDown;
	private Button button = Button.IDLE;
	public static enum Button 
	{
		Up,
		Down,
		IDLE
	}
	public Floor(int id)
	{
		this.id = id;
		this.GoingUp 	= new ArrayList<Passenger>();
		this.GoingDown	= new ArrayList<Passenger>();
	}
	public int getid() {
		return id;
	}
	public int UpSize() {
		return GoingUp.size();
	}
	public int DownSize () {
		return GoingDown.size();
	}
	public String FloorDirection(){
		if(button == Button.Up){
			return "UP";
		}else if(button == Button.Down){
			return "DOWN";
		}else{
			return "IDEL";
		}
	}
	public List<Passenger> GetGoingUp() {
		return GoingUp;
	}
	public List<Passenger> GetGoingDown() {
		return GoingDown;
	}
	public String GetButton(int cFloor, int dFloor) {
		int dir = dFloor - cFloor;
		
		if (dir < 0) {
			this.button = Button.Down;
			return "DOWN";
		} else if (dir > 0) {
			this.button = Button.Up;
			return "UP";
		} else {
			this.button = Button.IDLE;
			return "NONE";
		}
	}
	public void addPassenger(Passenger newarival) {
		int dFloor = newarival.getcfloor();
		int cFloor = newarival.getdfloor();
		int dir = dFloor - cFloor;
		
		if (dir < 0) {
			GoingDown.add(newarival);
		} else if (dir > 0) {
			GoingUp.add(newarival);
		}
		if(button == Button.IDLE){
			GetButton(cFloor,dFloor);
		}
	}
}

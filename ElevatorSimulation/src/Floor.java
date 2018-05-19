import java.util.ArrayList;
import java.util.List;

public class Floor {

	private int id;
	private List<Passenger> GoingUpDown;
	private Button button = Button.IDLE;

	public static enum Button {
		Up, Down, IDLE
	}

	public Floor(int id) {
		this.id = id;
		this.GoingUpDown = new ArrayList<Passenger>();
	}

	public int getid() {
		return id;
	}

	public int UpDownSize() {
		return GoingUpDown.size();
	}

	public String ButtonSign() {
		if (button == Button.Up) {
			return "UP";
		} else if (button == Button.Down) {
			return "DOWN";
		} else {
			return "IDLE";
		}
	}

	public List<Passenger> GetGoingUpDown() {
		return GoingUpDown;
	}

	public void GetButton(int cFloor, int dFloor) {
		int dir = dFloor - cFloor;

		if (dir < 0) {
			this.button = Button.Down;
		} else if (dir > 0) {
			this.button = Button.Up;
		} else {
			this.button = Button.IDLE;
		}
	}

	public void addPassenger(Passenger newarival, MainControll Controller) {
		int dFloor = newarival.getcfloor();
		int cFloor = newarival.getdfloor();
		if (button == Button.IDLE && GoingUpDown.size() > 0) {
			int EdFloor = GoingUpDown.get(0).getdfloor();
			int EcFloor = GoingUpDown.get(0).getcfloor();
			GetButton(EcFloor, EdFloor);
			Controller.signal(id);
		} else {
			GoingUpDown.add(newarival);
			GetButton(cFloor, dFloor);
			Controller.signal(id);
		}
	}
}

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainBuilding {

	static Random random = new Random(System.nanoTime());
	static Random randomFloor = new Random(System.nanoTime());
	static List<Passenger> ComingPassengersQueue = new ArrayList<Passenger>();
	static List<Floor> BuildingFloors = new ArrayList<Floor>();
	static List<Elevator> BuildingElevators = new ArrayList<Elevator>();
	static double time = 0.00;
	static int PassengerCount = 0;
	static int passid = 0;
	private static double cpt = onedigit(getPassengerTime() + currenttime());

	public static double onedigit(double a) {
		int temp = (int) (a * 10.0);
		double b = ((double) temp) / 10.0;
		return b;
	}

	public static double getPassengerTime() {
		return onedigit(((Math.log(1 - random.nextDouble()) / (-0.2))));
	}

	public static int getRandomFloor(int a) {
		int randomNum = randomFloor.nextInt(10);
		while (randomNum == a) {
			randomNum = randomFloor.nextInt(10);
		}
		return randomNum;
	}

	public static int getRandomFloor() {
		int randomNum = randomFloor.nextInt(10);
		return randomNum;
	}

	public static double currenttime() {
		return onedigit(time);
	}

	public static void increasetime(double Addtime) {
		time += Addtime;
	}

	public static void addNewPassengerToFloor(Passenger newPassenger, MainControll Controller) {
		int fc = newPassenger.getcfloor();
		// System.out.println("Passenger "+newPassenger.getid()+" arrived at floor
		// "+fc);
		BuildingFloors.get(fc).addPassenger(newPassenger, Controller);

	}

	public static Passenger newPassenger(double cppt) {
		int cfp = getRandomFloor();
		Passenger firstPassenger = new Passenger(passid++, cfp, getRandomFloor(cfp), cppt);
		return firstPassenger;
	}

	public static void exponentiallyCreatePerson(MainControll Controller) {
		if (cpt == currenttime()) {
			PassengerCount++;
			Passenger firstPassenger = newPassenger(cpt);
			addNewPassengerToFloor(firstPassenger, Controller);
			cpt = onedigit(getPassengerTime() + currenttime());
		} else if (cpt < currenttime()) {
			cpt = onedigit(getPassengerTime() + currenttime());
		}
	}

	public static void initializeElevators(int numberCount) {
		for (int i = 0; i < numberCount; i++) {
			Elevator CreateElevator = new Elevator(i, 0);
			BuildingElevators.add(CreateElevator);
		}
	}

	public static void initializeFloors() {
		for (int i = 0; i < 10; i++) {
			BuildingFloors.add(new Floor(i));
		}
	}

	public static MainControll initializeMainControll() {
		return new MainControll(BuildingElevators, BuildingFloors);
	}

	public static void main(String[] args) {
		initializeElevators(1);
		initializeFloors();
		MainControll controller = initializeMainControll();

		while (currenttime() < 1000.0) {
			exponentiallyCreatePerson(controller);
			controller.RunElevator(currenttime());
			increasetime(0.1);
		}

		System.out.println("Program Ended" + PassengerCount);
	}
}

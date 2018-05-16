import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainBuilding {
	
	static Random random	  = new Random(System.nanoTime());
	static Random randomFloor = new Random(System.nanoTime());
	static List<Passenger> ComingPassengersQueue = new ArrayList<Passenger>();
	static List<Floor> BuildingFloors = new ArrayList<Floor>();
	static double time = 0.00;
	static int PassengerCount = 0;
	static int passid = 0;
	public static double twodigit (double a){
		int temp = (int)(a*100.0);
		double b = ((double)temp)/100.0;
		return b;
	}
	public static double getPassengerTime() {
		return  twodigit(((Math.log(1-random.nextDouble())/(-0.2))));
	}
	public static int getRandomFloor(int a){
		int randomNum = randomFloor.nextInt(10);
		while (randomNum == a){
			randomNum = randomFloor.nextInt(10);
		}
		return randomNum;
	}
	public static int getRandomFloor(){
		int randomNum = randomFloor.nextInt(10);
		return randomNum;
	}
	public static double currenttime (){
		return twodigit(time);
	}
	public static void increasetime (double Addtime){
		time+=Addtime;
	}
	public static void addNewPassengerToFloor (Passenger newPassenger){
		if(ComingPassengersQueue.size()>0){
			if(ComingPassengersQueue.get(0).getArrival() == currenttime()){
				Passenger avc = ComingPassengersQueue.get(0);
				int fc = avc.getcfloor();
				BuildingFloors.get(fc).addPassenger(avc);
			}
		}
	}
	public static Passenger newPassenger(){
		int cfp = getRandomFloor();
		Passenger firstPassenger = new Passenger(passid++,cfp,getRandomFloor(cfp),getPassengerTime()+currenttime());
		return firstPassenger;
	}
	public static void main(String[] args) 
	{
		Elevator FirstElevator = new Elevator (1,0);
		for (int i = 0; i < 10; i ++ ){
			BuildingFloors.add(new Floor(i));}
		MainControll controller = new MainControll(BuildingFloors);
		
		Passenger firstPassenger = newPassenger();
		ComingPassengersQueue.add(firstPassenger);
		while(currenttime () <1000.00){
			if(ComingPassengersQueue.size()>0){
				//add person to floor through MainController.
			}
			if(controller.checkFloors()){
				if(controller.checkAvailability ()){
					controller.requestE();
					//Request elevator and assign one Succesfully!!!!!!!!!!!!!!!!!!!!!!!!!Awawd
				}
			}
			controller.timepassone ();
			increasetime (0.01);
		}
		System.out.println("Program Ended");
	}
}

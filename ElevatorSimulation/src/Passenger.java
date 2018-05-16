
public class Passenger {
	
	private int id;
	private int dfloor;
	private int cfloor;
	private double arrivaltime = 0.00;
	private double timewaited = 0.00;
	public Passenger(int id, int a, int b, double ab){
		this.id = id;
		this.cfloor = a;
		this.dfloor = b;
		this.arrivaltime = ab;
	}
	public int getcfloor(){
		return this.cfloor;
	}
	public int getdfloor(){
		return this.dfloor;
	}
	public void UpdateWait(double a){
		this.timewaited += a;
	}
	public double getWait (){
		return timewaited;
	}
	public double getArrival(){
		return arrivaltime;
	}
	public int getid(){
		return id;
	}
}
